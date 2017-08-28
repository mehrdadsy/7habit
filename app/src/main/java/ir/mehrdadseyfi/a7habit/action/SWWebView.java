package ir.mehrdadseyfi.a7habit.action;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.webkit.WebView;

/**
 * @author <a href="mailto:siavash.mehrabi@gmail.com">Conscript</a>
 * @version 1.0
 * @since 1.0-MVP
 */
public class SWWebView extends WebView {
    public SWWebView(Context context) {
        super(context);
    }

    public SWWebView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SWWebView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public SWWebView(Context context, AttributeSet attrs, int defStyle, boolean privateBrowsing) {
        super(context, attrs, defStyle, privateBrowsing);
    }

    private long lastEventTime = -1;

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        int action = ev.getAction();

        switch (action) {
            case MotionEvent.ACTION_MOVE: {
                return super.onTouchEvent(ev);
            }
            case MotionEvent.ACTION_DOWN: {
                return super.onTouchEvent(ev);
            }
            case MotionEvent.ACTION_UP: {
                if (System.currentTimeMillis() - lastEventTime < 1000) {
                    //Cancel all touch actions
                    ev.setAction(MotionEvent.ACTION_CANCEL);
                    super.onTouchEvent(ev);
                    //Restart the current action
                    ev.setAction(MotionEvent.ACTION_DOWN);
                    super.onTouchEvent(ev);
                }
                ev.setAction(MotionEvent.ACTION_UP);
                lastEventTime = System.currentTimeMillis();
                return super.onTouchEvent(ev);
            }
        }
        return super.onTouchEvent(ev);
    }
}
