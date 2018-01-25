package com.syntel.bo;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.bson.Document;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.syntel.model.CompositeDetail;



@Controller
public class Composite {

	@Value("${customer.url}")
	private String url;
	
	@Value("${hyper.url}")
	private String Hyperurl;
	
	@Value("${recommendoffers.url}")
	private String recurl;

	
	public String CompositeCall(CompositeDetail image) {
		
			String id=image.getId();
			
			
			
		HttpHeaders headers = new HttpHeaders();
	
		headers.setContentType(MediaType.APPLICATION_JSON);	
		//String requestJson = "{'id':'"+id+"'}";
		String requestJson="{\"id\":\""+id+"\"}";
		HttpEntity<String> entity = new HttpEntity<String>(requestJson, headers);
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url);
		RestTemplate rt=new RestTemplate();
		rt.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        rt.getMessageConverters().add(new StringHttpMessageConverter());
       ResponseEntity<String> response = rt.exchange(builder.toUriString(), HttpMethod.POST, entity, String.class );
       String data=response.getBody();
       String result=offerrec(data);
       return result;
		
		
	}
	
	public String offerrec(String data){
		System.out.println(data);
		JSONObject obj = new JSONObject(data);
		int type = obj.getJSONObject("info").getInt("type");
		int existingcustomer=obj.getJSONObject("info").getInt("existingcustomer");
		int age=obj.getJSONObject("info").getInt("age");
		int gender=obj.getJSONObject("info").getInt("gender");
		int maritalstatus=obj.getJSONObject("info").getInt("maritalstatus");
		int noofdependants=obj.getJSONObject("info").getInt("noofdependants");
		int livingarrangement=obj.getJSONObject("info").getInt("livingarrangement");
		int addressclass=obj.getJSONObject("info").getInt("addressclass");
		int jobstatus=obj.getJSONObject("info").getInt("jobstatus");
		int occupation=obj.getJSONObject("info").getInt("occupation");
		int generalincome=obj.getJSONObject("info").getInt("generalincome");
		int overdraft=obj.getJSONObject("info").getInt("overdraft");
		int tax=obj.getJSONObject("info").getInt("tax");
		int oincome=obj.getJSONObject("info").getInt("oincome");
		int deposit=obj.getJSONObject("info").getInt("deposit");
		int frequency=obj.getJSONObject("info").getInt("frequency");
		int savings=obj.getJSONObject("info").getInt("savings");
		JSONArray sports = obj.getJSONArray("tag");
		JSONObject sport = sports.getJSONObject(0);
		int Eatingout=sport.getInt("totalSpend");
		JSONObject sport1 = sports.getJSONObject(1);
		int Entertainment=sport1.getInt("totalSpend");
		JSONObject sport2 = sports.getJSONObject(2);
		int Finance=sport2.getInt("totalSpend");
		JSONObject sport3 = sports.getJSONObject(3);
		int Fuel=sport3.getInt("totalSpend");
		JSONObject sport4 = sports.getJSONObject(4);
		int Gettingaround=sport4.getInt("totalSpend");
		JSONObject sport5 = sports.getJSONObject(5);
		int Groceries=sport5.getInt("totalSpend");
		JSONObject sport6 = sports.getJSONObject(6);
		int Holidays=sport6.getInt("totalSpend");
		JSONObject sport7 = sports.getJSONObject(7);
		int Home=sport7.getInt("totalSpend");
		JSONObject sport8 = sports.getJSONObject(8);
		int Keepingfit=sport8.getInt("totalSpend");
		JSONObject sport9 = sports.getJSONObject(9);
		int Kids=sport9.getInt("totalSpend");
		JSONObject sport10 = sports.getJSONObject(10);
		int Mortageorrent=sport10.getInt("totalSpend");
		JSONObject sport11 = sports.getJSONObject(11);
		int Other=sport11.getInt("totalSpend");
		JSONObject sport12 = sports.getJSONObject(12);
		int Pets=sport12.getInt("totalSpend");
		JSONObject sport13 = sports.getJSONObject(13);
		int Stayingaway=sport13.getInt("totalSpend");
		JSONObject sport14 = sports.getJSONObject(14);
		int Style=sport14.getInt("totalSpend");
		JSONObject sport15 = sports.getJSONObject(15);
		int Tech=sport15.getInt("totalSpend");
		JSONObject sport16 = sports.getJSONObject(16);
		int Utilities=sport16.getInt("totalSpend");
		JSONObject sport17 = sports.getJSONObject(17);
		int Wellbeing=sport17.getInt("totalSpend");
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);	
		String json="{\"type\" :" +type+","+"\"existingcustomer\" :"+existingcustomer+","+"\"age\" :"+age+","+"\"gender\" :"+gender+ ","+"\"maritalstatus\" :"+maritalstatus+","+"\"noofdependants\" :"+noofdependants+","+"\"livingarrangement\" :"+livingarrangement+","+"\"addressclass\" :"+addressclass+" ,"+"\"jobstatus\" :"+jobstatus+","+"\"occupation\" :"+occupation+","+"\"generalincome\" :"+generalincome+","+"\"overdraft\" :"+overdraft+","+"\"tax\" :"+tax+","+"\"oincome\" :"+
				oincome+","+"\"deposit\" :"+deposit+","+"\"frequency\" :"+frequency+","+"\"savings\" :"+savings+","+"\"Eating out\":"+Eatingout+","+"\"Entertainment\":"
				+Entertainment+","+"\"Finance\":"+Finance+","+"\"Fuel\":"+Fuel+","+"\"Getting around\":"+Gettingaround+","+"\"Groceries\":"+Groceries+","+"\"Holidays\":"+Holidays+","+"\"Home\":"+Home+","+"\"Keeping fit\":"+Keepingfit+","+"\"Kids\":"+Kids+","+"\"Mortage or rent\":"+Mortageorrent+","+"\"Other\":"+Other+","+"\"Pets\":"+Pets+","+"\"Staying away\":"+Stayingaway+","+"\"Style\":"+Style+","+"\"Tech\":"+Tech+","+"\"Utilities\":"+Utilities+","+"\"Wellbeing\":"+Wellbeing+"}";
		HttpEntity<String> entity = new HttpEntity<String>(json, headers);
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(recurl);
		RestTemplate rt=new RestTemplate();
		rt.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        rt.getMessageConverters().add(new StringHttpMessageConverter());
       ResponseEntity<String> response = rt.exchange(builder.toUriString(), HttpMethod.POST, entity, String.class );
        return response.getBody();	
	
	}
		
	}
	
	
	
	
	

