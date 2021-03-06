package com.example.bb;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;
import android.util.Log;
import com.example.bb.MainActivity;

/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * <p>
 * <p>
 * TODO: Customize class - update intent actions, extra parameters and static
 * helper methods.
 */
public class MyIntentService extends IntentService {

    // TODO: Rename actions, choose action names that describe tasks that this
    // IntentService can perform, e.g. ACTION_FETCH_NEW_ITEMS
    private static final String ACTION_FOO = "com.example.bb.action.FOO";
    private static final String ACTION_BAZ = "com.example.bb.action.BAZ";

    // TODO: Rename parameters
    private static final String EXTRA_PARAM1 = "com.example.bb.extra.PARAM1";
    private static final String EXTRA_PARAM2 = "com.example.bb.extra.PARAM2";

    public MyIntentService() {
        super("MyIntentService");
    }

    /**
     * Starts this service to perform action Foo with the given parameters. If
     * the service is already performing a task this action will be queued.
     *
     * @see IntentService
     */
    // TODO: Customize helper method
    public static void startActionFoo(Context context, String param1, String param2) {
        Intent intent = new Intent(context, MyIntentService.class);
        intent.setAction(ACTION_FOO);
        intent.putExtra(EXTRA_PARAM1, param1);
        intent.putExtra(EXTRA_PARAM2, param2);
        context.startService(intent);
    }

    /**
     * Starts this service to perform action Baz with the given parameters. If
     * the service is already performing a task this action will be queued.
     *
     * @see IntentService
     */
    // TODO: Customize helper method
    public static void startActionBaz(Context context, String param1, String param2) {
        Intent intent = new Intent(context, MyIntentService.class);
        intent.setAction(ACTION_BAZ);
        intent.putExtra(EXTRA_PARAM1, param1);
        intent.putExtra(EXTRA_PARAM2, param2);
        context.startService(intent);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        String action = intent.getExtras().getString("param");
//        if (action.equals("oper1")){
//            Log.d("TAG666", "onHandleIntent: Operation1");
//            Intent broadcast_intent = new Intent();
//            broadcast_intent.setAction(WriteActivity.ACTION_UPDATE_UI);
//            sendBroadcast(broadcast_intent);
//        }
        Intent broadcast_intent = new Intent();
        switch (action){
            case "oper1":
                broadcast_intent.putExtra("operations", "1");
                break;
            case "oper2":
                broadcast_intent.putExtra("operations", "2");
                break;
            default:
                break;
        }
        broadcast_intent.setAction(WriteActivity.ACTION_UPDATE_UI);
        sendBroadcast(broadcast_intent);
    }

    /**
     * Handle action Foo in the provided background thread with the provided
     * parameters.
     */
    private void handleActionFoo(String param1, String param2) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    /**
     * Handle action Baz in the provided background thread with the provided
     * parameters.
     */
    private void handleActionBaz(String param1, String param2) {
        // TODO: Handle action Baz
        throw new UnsupportedOperationException("Not yet implemented");
    }
}