package com.idopter;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.Toast;

import com.idopter.requests.RestJsonClient;

public class AndropteActivity extends Activity {
	private EditText et_ip;
	private EditText et_port;
	private EditText et_response;
	private EditText et_request;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.principal);
		
		et_ip = (EditText)findViewById(R.id.et_ip);
		et_port = (EditText)findViewById(R.id.et_port);
		et_response = (EditText)findViewById(R.id.et_response);		
		et_request = (EditText)findViewById(R.id.et_request);		
		
		findViewById(R.id.bu_request).setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				request(et_ip.getText().toString(),
						et_port.getText().toString(), 
						et_request.getText().toString()); 
			}
		});
		findViewById(R.id.bu_clear).setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				et_ip.setText("");
				et_port.setText("");
				et_request.setText("");
			}
		});
		findViewById(R.id.bu_exit).setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				finish();
			}
		});
		/*
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		textfield = (EditText) findViewById(R.id.editText1);
		text = (TextView) findViewById(R.id.textView1);
		*/
	}
	
	public void request(String ip, String port,String request){
		try {
			et_response.append("\n"+RestJsonClient.connect(getUrl(ip,
							port,request)).toString());
		} catch (Exception e) {
			et_response.append("\n"+e.getMessage());
			e.printStackTrace();
		}
	}
	
	private String getUrl(String ip, String port, String request){
		return "http://"+ip+":"+port+"/"+request;
	}
	
	
	public void myClickHandler(View view) {
		Toast.makeText(this, "teste", Toast.LENGTH_LONG).show();
		
		/*
		switch(view.getId()){
			case R.id.bu_request:{
				request(et_ip.getText().toString(),et_port.getText().toString()); 
				}break;
			case R.id.bu_clear:{
				et_ip.setText("");
				et_port.setText("");
				et_request.setText("");				
			}break;
			case R.id.bu_exit:{
				finish();
			}
			}*/
			/*case R.id.button1:{
				try {
					String response = RestJsonClient.connect(textfield.getText().toString()).toString();
					text.setText(response);
					return;
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			}*/
		
	}
}