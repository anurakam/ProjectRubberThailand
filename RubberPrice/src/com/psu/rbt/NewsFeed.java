package com.psu.rbt;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

 
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;


public class NewsFeed extends Fragment {
	
	//@Override
   // public void onCreate(Bundle savedInstanceState) {
     //   super.onCreate(savedInstanceState);
    //    getActivity().setContentView(R.layout.activity_main);
 
     //   if (savedInstanceState == null) {
           // addRssFragment();
      //  }
  //  }
 
    
	
	// private List<Message> messagesList;
	  //  private ListView listView;
	//private RSSFeed myRssFeed = null;
	    
	/* @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        // Get the view
	        getActivity().setContentView(R.layout.activitie_newsfeed);


	    }    */
 
   @Override
   public View onCreateView(LayoutInflater inflater, ViewGroup container,
           Bundle savedInstanceState) {
 
       View rootView = inflater.inflate(R.layout.activitie_newsfeed, container, false);
       if (savedInstanceState == null) {
            addRssFragment();
       }
        
        
      /*  try {
			URL rssUrl = new URL("http://www.rubbersurat.com/index.php?option=com_content&view=category&id=55&Itemid=102&format=feed&type=rss");
			SAXParserFactory mySAXParserFactory = SAXParserFactory.newInstance();
			SAXParser mySAXParser = mySAXParserFactory.newSAXParser();
			XMLReader myXMLReader = mySAXParser.getXMLReader();
			RSSHandler myRSSHandler = new RSSHandler();
			myXMLReader.setContentHandler(myRSSHandler);
			InputSource myInputSource = new InputSource(rssUrl.openStream());
			myXMLReader.parse(myInputSource);
			
			myRssFeed = myRSSHandler.getFeed();	
		} catch (MalformedURLException e) {
			e.printStackTrace();	
		} catch (ParserConfigurationException e) {
			e.printStackTrace();	
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();	
		}
		
		if (myRssFeed!=null)
		{
			TextView feedTitle = (TextView)rootView.findViewById(R.id.feedtitle);
			TextView feedDescribtion = (TextView)rootView.findViewById(R.id.feeddescribtion);
			TextView feedPubdate = (TextView)rootView.findViewById(R.id.feedpubdate);
			TextView feedLink = (TextView)rootView.findViewById(R.id.feedlink);
			feedTitle.setText(myRssFeed.getTitle());
			feedDescribtion.setText(myRssFeed.getDescription());
			feedPubdate.setText(myRssFeed.getPubdate());
			feedLink.setText(myRssFeed.getLink());
			
			ArrayAdapter<RSSItem> adapter =
					new ArrayAdapter<RSSItem>(getActivity(),
							android.R.layout.simple_list_item_1,myRssFeed.getList());
			setListAdapter(adapter);
			
		}*/
        
      //เชื่อม listView เข้ากับ View
       // listView = (ListView) rootView.findViewById(R.id.ListView01);
 
        //ทำการ Load ข้อมูล
       // loadFeed("http://www.javaworld.com/index.xml");

         
        return rootView;
    }
   private void addRssFragment() {
       FragmentManager manager = getActivity().getSupportFragmentManager();
       FragmentTransaction transaction = manager.beginTransaction();
       RssFragment fragment = new RssFragment();
       transaction.add(R.id.fragment_container, fragment);
       transaction.commit();
   }

   @Override
	public void onSaveInstanceState(Bundle outState) {
       super.onSaveInstanceState(outState);
       outState.putBoolean("fragment_added", true);
   }
    //@Override
	//public void onStart(){
	//	super.onStart();
		
	//	changePage();
		
	//	}
   /* public void changePage(){
    	try {
			URL rssUrl = new URL("http://www.rubbersurat.com/index.php?option=com_content&view=category&id=55&Itemid=102&format=feed&type=rss");
			SAXParserFactory mySAXParserFactory = SAXParserFactory.newInstance();
			SAXParser mySAXParser = mySAXParserFactory.newSAXParser();
			XMLReader myXMLReader = mySAXParser.getXMLReader();
			RSSHandler myRSSHandler = new RSSHandler();
			myXMLReader.setContentHandler(myRSSHandler);
			InputSource myInputSource = new InputSource(rssUrl.openStream());
			myXMLReader.parse(myInputSource);
			
			myRssFeed = myRSSHandler.getFeed();	
		} catch (MalformedURLException e) {
			e.printStackTrace();	
		} catch (ParserConfigurationException e) {
			e.printStackTrace();	
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();	
		}
		
		if (myRssFeed!=null)
		{
			TextView feedTitle = (TextView)getView().findViewById(R.id.feedtitle);
			TextView feedDescribtion = (TextView)getView().findViewById(R.id.feeddescribtion);
			TextView feedPubdate = (TextView)getView().findViewById(R.id.feedpubdate);
			TextView feedLink = (TextView)getView().findViewById(R.id.feedlink);
			feedTitle.setText(myRssFeed.getTitle());
			feedDescribtion.setText(myRssFeed.getDescription());
			feedPubdate.setText(myRssFeed.getPubdate());
			feedLink.setText(myRssFeed.getLink());
			
			ArrayAdapter<RSSItem> adapter =
					new ArrayAdapter<RSSItem>(getActivity(),
							android.R.layout.simple_list_item_1,myRssFeed.getList());
			setListAdapter(adapter);
			
		}
    }*/
   /* @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
		Intent intent = new Intent(getActivity(),ShowDetails.class);
		Bundle bundle = new Bundle();
		bundle.putString("keyTitle", myRssFeed.getItem(position).getTitle());
		bundle.putString("keyDescription", myRssFeed.getItem(position).getDescription());
		bundle.putString("keyLink", myRssFeed.getItem(position).getLink());
		bundle.putString("keyPubdate", myRssFeed.getItem(position).getPubdate());
		intent.putExtras(bundle);
		startActivity(intent);	
	}
    
    
  /*  private void loadFeed(String url){
        try{
            //สร้าง AndroidSaxFeedParser เพื่อใช้ในการดึงข้อมูล และกำหนด URL ด้วย
            AndroidSaxFeedParser parser = new AndroidSaxFeedParser(url);
 
            //ทำการดึงข้อมูล ผลลัพธ์ใส่ messages
            messagesList = parser.parse();
 
            //เตรียมข้อมูลเพื่อแสดงใน ListView
            List<String> titles = new ArrayList<String>();
            for (Message msg : messagesList){
                titles.add(msg.getTitle());
            }
 
            //แสดงข้อมูลที่ได้เข้าไปใน ListView
            listView.setAdapter(new ArrayAdapter<String>(getActivity(),
                    android.R.layout.simple_list_item_1, titles));
            
        } catch (Throwable t){
            Log.e("FeedParserXML",t.getMessage(),t);
        }
    }*/


}
