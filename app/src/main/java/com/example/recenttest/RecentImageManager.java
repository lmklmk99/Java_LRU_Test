package com.example.recenttest;

import java.util.HashMap;
import java.util.LinkedList;

import android.graphics.Bitmap;

public class RecentImageManager {
	
	public final int MAX_CNT = 5;
	private int mDataCnt = 0;

	private HashMap<Integer, Node> mDataHashMap = new HashMap<Integer, Node>();
	private Node mHead;
	private Node mTail;
	
	public void setBitmap( int id, Bitmap bitmap ) {
		
		if( mHead == null ) {
			mHead = new Node( id, bitmap, null, null );
			mTail = mHead;
		}
		else {
			
			if( mDataCnt >= MAX_CNT ) {
				Node deleteNode = mTail;				
				mTail = deleteNode.getPrevNode();
				mTail.setNextNode(null);
				
				mDataHashMap.remove(deleteNode.getId());				
				mDataCnt--;
			}
			
			Node tempNode = mHead;
			mHead = new Node( id, bitmap, null, tempNode );
			tempNode.setPrevNode(mHead);
		}
		
		mDataHashMap.put(id, mHead);
		mDataCnt++;
	}
	
	public Bitmap getBitmap( int id ) {
		
		Node currNode = mDataHashMap.get(id);
		
		if( currNode == null ) {
			return null;
		}
		
		if( currNode.equals(mHead) == false ) {
			
			Node prevNode = currNode.getPrevNode();
			Node nextNode = currNode.getNextNode();

			if( currNode.equals(mTail) == true ) {
				prevNode.setNextNode(null);
				mTail = prevNode;
			}
			else {
				prevNode.setNextNode(nextNode);
				nextNode.setPrevNode(prevNode);
			}
			
			currNode.setPrevNode(null);
			currNode.setNextNode(mHead);
			mHead.setPrevNode(currNode);
			mHead = currNode;
		}
		
		return mHead.getBitmap();
	}
	
	public Bitmap getBitmapForIndex( int dataIndex ) {
		Node currNode = mHead;
		for( int index = 0; index < dataIndex; index++ ) {
			currNode = currNode.getNextNode();
		}
		return currNode.getBitmap();
	}
	
	public int getCount() {
		return mDataCnt;
	}	
}
