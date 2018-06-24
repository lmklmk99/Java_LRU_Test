package com.example.recenttest;

import java.util.LinkedList;

import android.graphics.Bitmap;

public class Node {

	private int mId;
	private Bitmap mBitmap;
	private Node mPrev;
	private Node mNext;
	
	public Node( int id, Bitmap bitmap, Node prev, Node next ) {
		mId = id;
		mBitmap = bitmap;
		mPrev = prev;
		mNext = next;		
	}
	
	public int getId() {
		return mId;
	}
	
	public Node getPrevNode() {
		return mPrev;
	}
	
	public void setPrevNode( Node prev ) {
		mPrev = prev;
	}
	
	public Node getNextNode() {
		return mNext;
	}
	
	public void setNextNode( Node next ) {
		mNext = next;
	}
	
	public Bitmap getBitmap() {
		return mBitmap;
	}
	
	public void setBitmap( Bitmap bitmap ) {
		mBitmap = bitmap;
	}
}
