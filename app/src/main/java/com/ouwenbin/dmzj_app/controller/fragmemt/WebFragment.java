package com.ouwenbin.dmzj_app.controller.fragmemt;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.just.agentweb.AgentWeb;
import com.ouwenbin.dmzj_app.R;


public class WebFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_web, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        String web_url = getArguments().getString("obj_url");
        AgentWeb agentWeb = AgentWeb.with(this)
                .setAgentWebParent((LinearLayout) getView(), new LinearLayout.LayoutParams(-1, -1))
                .useDefaultIndicator()
                .createAgentWeb()
                .ready()
                .go(web_url);
        requireActivity().findViewById(R.id.index_bottom_navigation).setVisibility(View.GONE);
    }
}
