package com.example.hp_2000.engineer_way_02;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class Frag_Syll extends Fragment {
        String arr[]={"COMPUTER SCIENCE","INFORMATION TECHNOLOGY","MECHANICAL ENGINEERING","CIVIL ENGINEERING","ELECTRONICS AND COMMUNICATION","ELECTRICAL"};
    String data;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view_list_view = inflater.inflate(R.layout.fragment_frag__syll, container, false);
        getActivity().setTitle("Syllabus B.Tech");
        ListView listView= (ListView) view_list_view.findViewById(R.id.list_view);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,arr);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView textView = (TextView) view;
                data= textView.getText().toString();
                if(data == "CIVIL ENGINEERING") {  Toast.makeText(getContext(),"Selected:"+data, Toast.LENGTH_SHORT).show();}
                if(data == "COMPUTER SCIENCE") {  Toast.makeText(getContext(),"Selected:"+data, Toast.LENGTH_SHORT).show();}
                if(data == "INFORMATION TECHNOLOGY") {  Toast.makeText(getContext(),"Selected:"+data, Toast.LENGTH_SHORT).show(); }
                if(data == "MECHANICAL ENGINEERING") {  Toast.makeText(getContext(),"Selected:"+data, Toast.LENGTH_SHORT).show(); }
                if(data == "ELECTRONICS AND COMMUNICATION") {  Toast.makeText(getContext(),"Selected:"+data, Toast.LENGTH_SHORT).show(); }
                if(data == "ELECTRICAL") {  Toast.makeText(getContext(),"Selected:"+data, Toast.LENGTH_SHORT).show();}
            }
        });
        return view_list_view;
    }


}
