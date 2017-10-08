package ir.mehrdadseyfi.a7habit.action;/** * @author Nancy * @version 2.0 */import android.Manifest;import android.annotation.SuppressLint;import android.app.Activity;import android.app.AlertDialog;import android.content.Context;import android.content.DialogInterface;import android.content.Intent;import android.content.SharedPreferences;import android.content.pm.PackageManager;import android.net.Uri;import android.net.wifi.WifiManager;import android.os.AsyncTask;import android.os.Bundle;import android.os.PowerManager;import android.preference.PreferenceManager;import android.support.v4.app.ActivityCompat;import android.support.v4.widget.DrawerLayout;import android.support.v7.app.AppCompatActivity;import android.telephony.TelephonyManager;import android.util.Log;import android.view.GestureDetector;import android.view.Gravity;import android.view.View;import android.webkit.JavascriptInterface;import android.webkit.WebView;import android.widget.AdapterView;import android.widget.Button;import android.widget.EditText;import android.widget.ImageView;import android.widget.LinearLayout;import android.widget.ListView;import android.widget.TextView;import java.util.Calendar;import java.util.Date;import java.util.List;import ir.mehrdadseyfi.a7habit.AboutUsActivity;import ir.mehrdadseyfi.a7habit.Calender.CalenderActivity;import ir.mehrdadseyfi.a7habit.Calender.JobDB;import ir.mehrdadseyfi.a7habit.Calender.ShowJobDayListAdapter;import ir.mehrdadseyfi.a7habit.R;import ir.mehrdadseyfi.a7habit.SquareTasksActivity;import ir.mehrdadseyfi.a7habit.TwentyOneDays.TwentyOneDaysActivity;import ir.mehrdadseyfi.a7habit.Vista.VistaActivity;import ir.mehrdadseyfi.a7habit.action.service.ActivationType;import ir.mirrajabi.persiancalendar.PersianCalendarView;import ir.mirrajabi.persiancalendar.core.PersianCalendarHandler;import ir.mirrajabi.persiancalendar.core.models.PersianDate;import me.toptas.fancyshowcase.DismissListener;import me.toptas.fancyshowcase.FancyShowCaseView;//import ir.mehrdadseyfi.action.development.R;public class ScormPlayerActivity extends AppCompatActivity {    @SuppressWarnings("UnusedDeclaration")    private static final String TAG = "ScormPlayerActivity";    private PowerManager.WakeLock wakeLock;    private GestureDetector gestureDetector;    Context mContext = this;    ImageView vista1;    PersianCalendarView calendarView;    private ActivationManager activationManager;    private WebView webView;    private Calendar lockDate = Calendar.getInstance();    private static String deviceId = "";    private static SharedPreferences preferences = null;    private String courseName;    private String importedSerialCode;    DrawerLayout mDrawerLayout;    Context mContex = this;    ImageView cal;    ImageView tele;    Button olaviyat;    Button days_21;    int day_jomle;    int i;    public ActivationType activationType;    /**     * Called when the activity is first created.     */    @SuppressLint({"AddJavascriptInterface", "SetJavaScriptEnabled"})    @Override    public void onCreate(Bundle savedInstanceState) {        lockDate.set(2014, Calendar.FEBRUARY, 1);        courseName = "staff-performance-evaluation";        WifiManager m_wm = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);        String m_wlanMacAdd = m_wm.getConnectionInfo().getMacAddress();        //TelephonyManager telephonyManager = (TelephonyManager) getApplicationContext().getSystemService(Context.TELEPHONY_SERVICE);        TelephonyManager telephonyManager = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);//        deviceId = telephonyManager.getDeviceId();//        if (deviceId == null || deviceId .length() == 0) {////            deviceId = Settings.Secure.getString(getApplication().getContentResolver(), Settings.Secure.ANDROID_ID);//        }        preferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());        super.onCreate(savedInstanceState);        setContentView(R.layout.activity_main);        addtoday();        goToVista();        goToSocial();        setmDrawerLayout();        addHelp();        todayJomle();///show drawer        mDrawerLayout = (DrawerLayout) findViewById(R.id.my_drawer_layout);        ImageView img = (ImageView) findViewById(R.id.drawers);        img.setOnClickListener(new View.OnClickListener() {            @Override            public void onClick(View v) {                mDrawerLayout.openDrawer(Gravity.RIGHT);            }        });        activationManager = new AutomaticActivationManager(                "http://elco21.com",                "/service/api/activate",                "IMEI-" + deviceId,                courseName,                preferences);//        if (!activationManager.haveSerialCode()) {//            Log.d("Activation","dont have serial saved");//            getSerialFromUserByDialog();//        }//        else {//            Log.d("Activation","have serial saved");//            continueActivation();//        }    }    @JavascriptInterface    public void activateByInternet() {        Log.d("ACTIVATION", "Before activation: isActive>" + String.valueOf(activationManager.isActive()));        new AsyncTask<String, Void, Void>() {            private Throwable throwable;            @Override            protected Void doInBackground(String... params) {                try {                    activationManager.activate();                } catch (Throwable throwable) {                    this.throwable = throwable;                }                return null;            }            @Override            protected void onPostExecute(Void ignored) {               if (throwable == null) {                   if (activationManager.isActive()) {                      webView.loadUrl("javascript:activationSuccessful()");//                 }else {                       showErrorByDialog();                  }                   Log.d("ACTIVATION", "After activation: isActive>" + String.valueOf(activationManager.isActive()));               } else {                  throwable.printStackTrace();                   if (new Date().getTime() > lockDate.getTime().getTime()) {                       enforceActivation();                  }              }            }        }.execute();    }    @JavascriptInterface    public void activateByTel() {        Log.d("ACTIVATION", "Before activation: isActive>" + String.valueOf(activationManager.isActive()));        new AsyncTask<String, Void, Void>() {            private Throwable throwable;            @Override            protected Void doInBackground(String... params) {                try {                    activationManager.offlineActivate();                } catch (Throwable throwable) {                    this.throwable = throwable;                }                return null;            }            @Override            protected void onPostExecute(Void ignored) {                if (throwable == null) {                    if (activationManager.isActive()) {                        startActivity(new Intent(ScormPlayerActivity.this, VistaActivity.class));                    } else {                        showErrorByDialog();                    }                    Log.d("ACTIVATION", "After activation: isActive>" + String.valueOf(activationManager.isActive()));                } else {                    throwable.printStackTrace();                    if (new Date().getTime() > lockDate.getTime().getTime()) {                        enforceActivation();                    }                }            }        }.execute();    }    private void enforceActivation() {        new AlertDialog.Builder(this)                .setTitle("نیاز به فعال‌سازی")                .setMessage("زمان استفاده‌ی رایگان از این برنامه به پایان رسیده است. لطفاً عملیات فعال‌سازی را انجام دهید")                .setPositiveButton("خروج", new DialogInterface.OnClickListener() {                    public void onClick(DialogInterface dialog, int which) {                        finish();                    }                })                .setIcon(android.R.drawable.ic_dialog_alert)                .setCancelable(false)                .show();    }    @Override    protected void onResume() {        addtoday();        super.onResume();        if (!AndroidWebServer.isAlive()) {            AndroidWebServer.start();        }    }    @Override    public void onBackPressed() {        AndroidWebServer.stop();        super.onBackPressed();    }    @JavascriptInterface    public boolean isActive() {        return activationManager.isActive();    }//    public boolean isConnectedToInternet() {//        ConnectivityManager connectivity = (ConnectivityManager) getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);//        if (connectivity != null) {//            NetworkInfo[] info = connectivity.getAllNetworkInfo();//            if (info != null)//                for (NetworkInfo anInfo : info) {//                    if (anInfo.getState() == NetworkInfo.State.CONNECTED) {//                        return true;//                    }//                }//        }//        return false;//    }    private void getSerialFromUserByDialog() {        final AlertDialog.Builder serialCodeDialog = new AlertDialog.Builder(this);        serialCodeDialog.setTitle("سریال کد");        serialCodeDialog.setMessage("لطفاً سریال کد خود را وارد کنید");        final EditText serialCodeTextEdit = new EditText(this);        serialCodeDialog.setView(serialCodeTextEdit);        serialCodeDialog.setPositiveButton("ثبت", new DialogInterface.OnClickListener() {            public void onClick(DialogInterface dialog, int which) {                importedSerialCode = serialCodeTextEdit.getText().toString().trim();                if (importedSerialCode != null && importedSerialCode.length() == 16) {                    activationManager.setSerialId(importedSerialCode);                    activationManager.setSerialCodeOfUser();                    continueActivation();                    dialog.cancel();                } else {                    showErrorByDialog();                }            }        });        if (new Date().getTime() < lockDate.getTime().getTime()) {            serialCodeDialog.setNegativeButton("خروج", new DialogInterface.OnClickListener() {                public void onClick(final DialogInterface dialog, int which) {                    dialog.cancel();                }            });            serialCodeDialog.setCancelable(true);        } else {            serialCodeDialog.setCancelable(false);        }        serialCodeDialog.show();    }    private void continueActivation() {        activationManager.setSerialId(activationManager.getSerialCodeOfUser());        if (!activationManager.isActive()) {            if (true) {                activateByInternet();            } else if (activationType == null) {                if (activationManager.inSmsStatus()) {                    getActivationCodeFromUser();                }            } else {                getActivationCodeFromUser();            }        }    }    private void getActivationCodeFromUser() {        final AlertDialog.Builder activationCodeDialog = new AlertDialog.Builder(this);        activationCodeDialog.setTitle("کد فعال‌سازی نرم‌افزار");        activationCodeDialog.setMessage("لطفاً کدفعال‌سازی خود را وارد کنید");        final EditText activationCodeTextEdit = new EditText(this);        activationCodeDialog.setView(activationCodeTextEdit);        activationCodeDialog.setCancelable(false);        activationCodeDialog.setPositiveButton("ثبت", new DialogInterface.OnClickListener() {            public void onClick(DialogInterface dialog, int which) {                String activationCode = activationCodeTextEdit.getText().toString().trim();                if (activationCode.trim() != null && activationCode.length() == 16) {                    activationManager.setUserActivationCode(activationCode);                    activateByTel();                    dialog.cancel();                } else {                    showErrorByDialog();                }            }        });        activationCodeDialog.show();    }    private void showErrorByDialog() {        AlertDialog.Builder errorDialog = new AlertDialog.Builder(this);        errorDialog.setTitle("کد وارد شده اشتباه می‌باشد.");        errorDialog.setMessage("لطفاً مجددا کد را وارد کنید.");        errorDialog.setIcon(android.R.drawable.ic_dialog_alert);        errorDialog.setNeutralButton("OK", new DialogInterface.OnClickListener() {            public void onClick(DialogInterface dialog, int which) {                finish();            }        });        if (new Date().getTime() < lockDate.getTime().getTime()) {            errorDialog.setNegativeButton("خروج", new DialogInterface.OnClickListener() {                public void onClick(final DialogInterface dialog, int which) {                    dialog.cancel();                }            });            errorDialog.setCancelable(true);        } else {            errorDialog.setCancelable(false);        }        errorDialog.show();    }    public void addtoday() {        ListView mylist = (ListView) findViewById(R.id.mylist_to);        calendarView = (PersianCalendarView) findViewById(R.id.persian_calendar_to);        PersianCalendarHandler calendarHandler;        calendarHandler = calendarView.getCalendar();        PersianDate today1 = calendarHandler.getToday();        Date currentTime = Calendar.getInstance().getTime();        day_jomle=currentTime.getHours();        List<JobDB> models1 = JobDB.find(JobDB.class, "year= ? and mount= ? and day= ?", String.valueOf(today1.getYear()), String.valueOf(today1.getMonth()), String.valueOf(today1.getDayOfMonth()));       i=models1.size();        BackGroundIf();        ShowJobDayListAdapter adapter = new ShowJobDayListAdapter(models1, this);        mylist.setAdapter(adapter);        ImageView imgBackGround = (ImageView) findViewById(R.id.ifemp);        mylist.setOnItemClickListener(new AdapterView.OnItemClickListener() {            @Override            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {                startActivity(new Intent(ScormPlayerActivity.this, CalenderActivity.class));            }        });    }    public void goToVista() {        findViewById(R.id.vista).setOnClickListener(new View.OnClickListener() {            @Override            public void onClick(View v) {                startActivity(new Intent(ScormPlayerActivity.this, VistaActivity.class));            }        });        findViewById(R.id.olaviyat).setOnClickListener(new View.OnClickListener() {            @Override            public void onClick(View v) {                startActivity(new Intent(ScormPlayerActivity.this, SquareTasksActivity.class));            }        });        findViewById(R.id.days_21).setOnClickListener(new View.OnClickListener() {            @Override            public void onClick(View v) {                startActivity(new Intent(ScormPlayerActivity.this, TwentyOneDaysActivity.class));            }        });    }    public void goToSocial() {        tele = (ImageView) findViewById(R.id.tele);        ImageView insta = (ImageView) findViewById(R.id.insta);        tele.setOnClickListener(new View.OnClickListener() {            @Override            public void onClick(View v) {                Uri uri = Uri.parse("http://t.me/coaches21"); // missing 'http://' will cause crashed                Intent intent = new Intent(Intent.ACTION_VIEW, uri);                startActivity(intent);            }        });        insta.setOnClickListener(new View.OnClickListener() {            @Override            public void onClick(View v) {                Uri uri = Uri.parse("http://www.instagram.com/_u/coaches21"); // missing 'http://' will cause crashed                Intent intent = new Intent(Intent.ACTION_VIEW, uri);                startActivity(intent);            }        });        cal = (ImageView) findViewById(R.id.cal);        cal.setOnClickListener(new View.OnClickListener() {            @Override            public void onClick(View v) {                startActivity(new Intent(ScormPlayerActivity.this, CalenderActivity.class));            }        });    }    public void setmDrawerLayout() {        Button aboutApp = (Button) findViewById(R.id.about_app);        Button web = (Button) findViewById(R.id.web);        Button elco21 = (Button) findViewById(R.id.elco21);        Button call = (Button) findViewById(R.id.call);        Button aboutUs = (Button) findViewById(R.id.about_us);        aboutApp.setOnClickListener(new View.OnClickListener() {            @Override            public void onClick(View v) {                Uri uri = Uri.parse("http://t.me/coaches21"); // missing 'http://' will cause crashed                Intent intent = new Intent(Intent.ACTION_VIEW, uri);                startActivity(intent);            }        });        web.setOnClickListener(new View.OnClickListener() {            @Override            public void onClick(View v) {                Uri uri = Uri.parse("http://www.co21.ir"); // missing 'http://' will cause crashed                Intent intent = new Intent(Intent.ACTION_VIEW, uri);                startActivity(intent);            }        });        elco21.setOnClickListener(new View.OnClickListener() {            @Override            public void onClick(View v) {                Uri uri = Uri.parse("http://www.elco21.com"); // missing 'http://' will cause crashed                Intent intent = new Intent(Intent.ACTION_VIEW, uri);                startActivity(intent);            }        });        call.setOnClickListener(new View.OnClickListener() {            @Override            public void onClick(View v) {                Intent callIntent = new Intent(Intent.ACTION_CALL);                callIntent.setData(Uri.parse("tel:+982188665899"));                if (ActivityCompat.checkSelfPermission(mContex, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {                    // TODO: Consider calling                    ActivityCompat.requestPermissions((Activity) mContex, new String[]{Manifest.permission.CALL_PHONE}, 1);                    //    ActivityCompat#requestPermissions                    // here to request the missing permissions, and then overriding                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,                    //                                          int[] grantResults)                    // to handle the case where the user grants the permission. See the documentation                    // for ActivityCompat#requestPermissions for more details.                    return;                }                startActivity(callIntent);            }        });        aboutUs.setOnClickListener(new View.OnClickListener() {            @Override            public void onClick(View v) {                Intent i = new Intent(ScormPlayerActivity.this, AboutUsActivity.class);                startActivity(i);            }        });    }    public void addHelp() {        olaviyat = (Button) findViewById(R.id.olaviyat);        days_21 = (Button) findViewById(R.id.days_21);         vista1=(ImageView)findViewById(R.id.vista);        ImageView help = (ImageView) findViewById(R.id.help);        help.setOnClickListener(new View.OnClickListener() {            @Override            public void onClick(View v) {                new FancyShowCaseView.Builder((Activity) mContext)                        .focusOn(cal)                        .backgroundColor(R.color.primary_light)                        .title("با استفاده از این دکمه می توانید وارد برنامه روزانه شوید")                        .titleStyle(R.style.s, Gravity.TOP | Gravity.CENTER)                        .dismissListener(new DismissListener() {                            @Override                            public void onDismiss(String id) {                                // FancyShowCaseView is dismissed by user                                new FancyShowCaseView.Builder((Activity) mContext)                                        .focusOn(vista1)                                        .title("در این قسمت می توانید اهداف و رویا ها و نقش های خود در زندگی را بنویسید")                                        .backgroundColor(R.color.primary_light)                                        .titleStyle(R.style.s, Gravity.TOP | Gravity.CENTER)                                        .dismissListener(new DismissListener() {                                            @Override                                            public void onDismiss(String id) {                                                // FancyShowCaseView is dismissed by user                                                new FancyShowCaseView.Builder((Activity) mContext)                                                        .focusOn(olaviyat)                                                        .title("در این قسمت می توانید  کارهای خود الویت بدهید و ابتدا امور مهم را انجام دهید")                                                        .backgroundColor(R.color.primary_light)                                                        .titleStyle(R.style.s, Gravity.TOP | Gravity.CENTER)                                                        .dismissListener(new DismissListener() {                                                            @Override                                                            public void onDismiss(String id) {                                                                // FancyShowCaseView is dismissed by user                                                                new FancyShowCaseView.Builder((Activity) mContext)                                                                        .focusOn(days_21)                                                                        .title("در این قسمت می توانید در 21 روز (مرحله) عادات بد خود را با عادات خوب جایگزین کنید")                                                                        .backgroundColor(R.color.primary_light)                                                                        .titleStyle(R.style.s, Gravity.TOP | Gravity.CENTER)                                                                        .dismissListener(new DismissListener() {                                                                            @Override                                                                            public void onDismiss(String id) {                                                                                // FancyShowCaseView is dismissed by user                                                                            }                                                                            @Override                                                                            public void onSkipped(String id) {                                                                                // Skipped because it was setup to shown only once and shown before                                                                            }                                                                        })                                                                        .build()                                                                        .show();                                                            }                                                            @Override                                                            public void onSkipped(String id) {                                                                // Skipped because it was setup to shown only once and shown before                                                            }                                                        })                                                        .build()                                                        .show();                                            }                                            @Override                                            public void onSkipped(String id) {                                                // Skipped because it was setup to shown only once and shown before                                            }                                        })                                        .build()                                        .show();                            }                            @Override                            public void onSkipped(String id) {                                // Skipped because it was setup to shown only once and shown before                            }                        })                        .build()                        .show();            }        });    }    public void todayJomle() {        final TextView todaJoml = (TextView) findViewById(R.id.today_jomle);        PreferenceManager.getDefaultSharedPreferences(this).edit().putString("1", "اندیشیدن به پایان هرچیز " +                "شیرینی ِحضورش را تلخ میکند ، " +                "بــگــذار پایان غافلگیرت کند " +                "درست مانند آغاز..").commit();        PreferenceManager.getDefaultSharedPreferences(this).edit().putString("2", "برای یک شروع خوب نباید عالی باشی ... " +                " اما برای عالی بودن باید شروع کنی ... !").commit();        PreferenceManager.getDefaultSharedPreferences(this).edit().putString("3", "شما راجع به آینده خود تصمیم نمیگیرید، بلکه راجع به عادتهایتان تصمیم میگیرید. " +                "این عادت هایتان هستند که آینده شما را میسازند. " +                "پس اگر الان موفق نیستید، عادت هایتان را تغییر دهید...").commit();        PreferenceManager.getDefaultSharedPreferences(this).edit().putString("4", "معمولا جاده های سخت  " +                "به مقصد های زیبا می رسند " +                "دوام بیاورید...").commit();        PreferenceManager.getDefaultSharedPreferences(this).edit().putString("5", "فصلِ اولِ زندگى خودت را ؛ " +                " " +                "با فصلِ پانزدهمِ زندگى کسی ديگر  " +                "مقايسه نكن.  " +                "مسير خودت را برو،  " +                "داستان زندگى خودت را بنويس  " +                "و هرگز جا نزن... ").commit();        PreferenceManager.getDefaultSharedPreferences(this).edit().putString("6", "به پسرم گفتم:\"نیازی نیست جزء 3 شاگرد برتر کلاس باشد. شاگرد متوسط بودن خوب است! زیرا فقط شاگردان متوسط وقت خالی دارند تا مهارت های دیگر هم بیاموزند\"").commit();        PreferenceManager.getDefaultSharedPreferences(this).edit().putString("7", "اگه بتونی تو موقعیتی \"منفی\"، " +                "\"مثبت\" بمونی؛ برنده ای...!").commit();        PreferenceManager.getDefaultSharedPreferences(this).edit().putString("8", "قانونی در روانشناسی میگوید: " +                "اگر شما تصویری از آنچه می خواهید باشید در ذهنتان بسازید و مدتی طولانی این تصویر را حفظ کنید، دقیقا همان خواهید شد.").commit();        PreferenceManager.getDefaultSharedPreferences(this).edit().putString("9", "برنده ها روی برد تمرکز می کنند " +                "بازنده ها روی برنده ها... " +                "ولی اگر بهترین باشی و عادتت برنده شدن بشود می تونی رو هر چیزی تمرکز کنی و باز هم ببری").commit();        PreferenceManager.getDefaultSharedPreferences(this).edit().putString("10", "هیچوقت بخاطر حرف دیگران تسلیم نشوید " +                " " +                "از حرف دیگران بعنوان یک محرک برای تلاش بیشتر استفاده کنید").commit();        PreferenceManager.getDefaultSharedPreferences(this).edit().putString("11", "انديشه ها بايد هميشه به سوي آينده پيش رود. اگر خدا مي خواست كه انسان به گذشته بازگردد يك چشم، پشت سر او مي گذاشت").commit();        PreferenceManager.getDefaultSharedPreferences(this).edit().putString("12", "برای مدت طولانى؛ " +                "از كسی متنفر نباشيد،  " +                "چون تنفر تبديل به  " +                "نقطه ضعفتان می شود " +                "ياد بگيريد  " +                "فرد مورد نظر را  " +                "از دايره توجه تان خارج کنید... ").commit();        PreferenceManager.getDefaultSharedPreferences(this).edit().putString("13", "درها برای کسانی گشوده می شوند که " +                "جسارت در زدن داشته باشند. " +                " " +                "پس برای رسیدن به موفقیت جسارت کن").commit();        PreferenceManager.getDefaultSharedPreferences(this).edit().putString("14", "شك هايت را باور نكن و هيچ گاه به باورهايت شك نكن").commit();        PreferenceManager.getDefaultSharedPreferences(this).edit().putString("15", "همیشه واقعا یه نفر هست که یواشکی هواتونو داره").commit();        PreferenceManager.getDefaultSharedPreferences(this).edit().putString("16", "تنها راه انجام دادن  " +                "کار بزرگ اینه که کاری  " +                "رو انجام بدی که عاشقشی ...").commit();        PreferenceManager.getDefaultSharedPreferences(this).edit().putString("17", "هیچکس تا امروز برنامه\u200Cای برای چاق\u200C شدن، شکست خوردن یا احمق بودن ننوشته است زیرا این چیزها وقتی اتفاق می افتد که شما برنامه نداشته باشید...").commit();        PreferenceManager.getDefaultSharedPreferences(this).edit().putString("18", "پیروزی نصیب افرادی می شود كه " +                "بیش از همه استقامت دارند " +                "ناپلئون").commit();        PreferenceManager.getDefaultSharedPreferences(this).edit().putString("19", "انسانهای بی هدف تا انتهای زندگی، ابزار انسانهای هدفمند خواهند بود!").commit();        PreferenceManager.getDefaultSharedPreferences(this).edit().putString("20", "ره آسمان درون است پر عشق را بجنبان  " +                "پر عشق چون قوی شد غم نردبان نماند " +                "حضرت مولانا").commit();        PreferenceManager.getDefaultSharedPreferences(this).edit().putString("21", "اگر یکبار تسلیم شی، " +                "برات یه عادت می شه ... " +                " " +                "پس هیچوقت تسلیم نشو!!!").commit();        PreferenceManager.getDefaultSharedPreferences(this).edit().putString("22", "انسان های ثروتمند تلویزیون های کوچک و کتابخانه های بزرگ دارند. فقیران کتابخانه های کوچک و تلویزیون های بزرگ!").commit();        PreferenceManager.getDefaultSharedPreferences(this).edit().putString("23", "ملتی که کتاب نخواند باید کل تاریخ را تجربه کند.").commit();        PreferenceManager.getDefaultSharedPreferences(this).edit().putString("24", "بسیاری از افراد موفقیت را با بدست آوردن پول و قدرت مساوی می پندارند در حالیکه سرمایه و ثروت واقعی توانایی ما در کنترل روانی مان در طول دوران زندگی است .").commit();        switch (day_jomle) {            case 1:                todaJoml.setText(PreferenceManager.getDefaultSharedPreferences(this).getString("1", ""));                break;            case 2:                todaJoml.setText(PreferenceManager.getDefaultSharedPreferences(this).getString("2", ""));                break;            case 3:                todaJoml.setText(PreferenceManager.getDefaultSharedPreferences(this).getString("3", ""));                break;            case 4:                todaJoml.setText(PreferenceManager.getDefaultSharedPreferences(this).getString("4", ""));                break;            case 5:                todaJoml.setText(PreferenceManager.getDefaultSharedPreferences(this).getString("5", ""));                break;            case 6:                todaJoml.setText(PreferenceManager.getDefaultSharedPreferences(this).getString("6", ""));                break;            case 7:                todaJoml.setText(PreferenceManager.getDefaultSharedPreferences(this).getString("7", ""));                break;            case 8:                todaJoml.setText(PreferenceManager.getDefaultSharedPreferences(this).getString("8", ""));                break;            case 9:                todaJoml.setText(PreferenceManager.getDefaultSharedPreferences(this).getString("9", ""));                break;            case 10:                todaJoml.setText(PreferenceManager.getDefaultSharedPreferences(this).getString("10", ""));                break;            case 11:                todaJoml.setText(PreferenceManager.getDefaultSharedPreferences(this).getString("11", ""));                break;            case 12:                todaJoml.setText(PreferenceManager.getDefaultSharedPreferences(this).getString("12", ""));                break;            case 13:                todaJoml.setText(PreferenceManager.getDefaultSharedPreferences(this).getString("13", ""));                break;            case 14:                todaJoml.setText(PreferenceManager.getDefaultSharedPreferences(this).getString("14", ""));                break;            case 15:                todaJoml.setText(PreferenceManager.getDefaultSharedPreferences(this).getString("15", ""));                break;            case 16:                todaJoml.setText(PreferenceManager.getDefaultSharedPreferences(this).getString("16", ""));                break;            case 17:                todaJoml.setText(PreferenceManager.getDefaultSharedPreferences(this).getString("17", ""));                break;            case 18:                todaJoml.setText(PreferenceManager.getDefaultSharedPreferences(this).getString("18", ""));                break;            case 19:                todaJoml.setText(PreferenceManager.getDefaultSharedPreferences(this).getString("19", ""));                break;            case 20:                todaJoml.setText(PreferenceManager.getDefaultSharedPreferences(this).getString("20", ""));                break;            case 21:                todaJoml.setText(PreferenceManager.getDefaultSharedPreferences(this).getString("21", ""));                break;            case 22:                todaJoml.setText(PreferenceManager.getDefaultSharedPreferences(this).getString("22", ""));                break;            case 23:                todaJoml.setText(PreferenceManager.getDefaultSharedPreferences(this).getString("23", ""));                break;            case 24:                todaJoml.setText(PreferenceManager.getDefaultSharedPreferences(this).getString("24", ""));                break;        }    }//image backgroun ba if    public void BackGroundIf() {        ImageView  imgBackGround = (ImageView) findViewById(R.id.ifemp);        if (i == 0) {            imgBackGround.setImageResource(R.drawable.noting);        } else {            imgBackGround.setImageDrawable(null);        }    }}