package view.video;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.widget.VideoView;

public class FullScreenVideoView extends VideoView{

	public FullScreenVideoView(Context context) {  
		super(context);  
		// TODO Auto-generated constructor stub  
		}  
		public FullScreenVideoView (Context context, AttributeSet attrs)  
		{  
		super(context,attrs);  
		}  
		public FullScreenVideoView(Context context, AttributeSet attrs,int defStyle)  
		{  
		super(context,attrs,defStyle);  
		}  
		@Override  
		protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec)  
		{  
		setBackgroundColor(Color.rgb(44, 44, 44));
//			getBackground().setAlpha(30);
		  int width = getDefaultSize(0, widthMeasureSpec);  
		  int height = getDefaultSize(0, heightMeasureSpec);  
		  setMeasuredDimension(width , height);  
		} 
		}


