package com.androidhunger.navigationdrawerexample;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by Avinash on 11-03-2017.
 */
public class WebViewFragment extends Fragment {
    public WebView wv;
    String gurl;
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        gurl = this.getArguments().getString("url");
        wv = (WebView) view.findViewById(R.id.webView);
        callWebClient(gurl);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {



        return inflater.inflate(R.layout.social, container, false);
    }

    private void callWebClient(String urll) {

        wv.setWebViewClient(new myWebViewClient());
        wv.getSettings().setLoadsImagesAutomatically(true);
        wv.getSettings().setJavaScriptEnabled(true);
        wv.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        wv.loadUrl(urll);
    }

    public class myWebViewClient extends WebViewClient {
        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            // TODO Auto-generated method stubsuper.onPageStarted(view, url, favicon);
        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            // TODO Auto-generated method stub
            Log.e("urhhllll", url);
            view.loadUrl(url);
            return true;

        }
    }
}
