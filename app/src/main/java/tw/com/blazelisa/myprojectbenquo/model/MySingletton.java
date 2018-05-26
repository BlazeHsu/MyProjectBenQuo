package tw.com.blazelisa.myprojectbenquo.model;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * 單例
 * 讀取時沒有就new一個出來用
 */
public class MySingletton {
    private static MySingletton mInstance;
    private static Context ctx;
    private RequestQueue requestQueue;

    private MySingletton(Context ctx){
        this.ctx = ctx;
        requestQueue = getRequestQueue();
    }
    private RequestQueue getRequestQueue(){
        if(requestQueue == null){
            requestQueue = Volley.newRequestQueue(ctx.getApplicationContext());

        }
        return requestQueue;
    }
    public static synchronized MySingletton getmInstance(Context context){
        if (mInstance == null){
            mInstance = new MySingletton(context);

        }
        return mInstance;
    }
}
