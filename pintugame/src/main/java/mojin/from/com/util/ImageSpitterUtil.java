package mojin.from.com.util;

import android.graphics.Bitmap;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/12/26.
 */
public class ImageSpitterUtil {
    /**
     *
     * @param bitmap  传入的图片
     * @param piece   图片分成的多少分
     * @return
     */
    public static List<ImagePiece> splitImage(Bitmap bitmap,int piece){
         List<ImagePiece> imagePieces=new ArrayList<ImagePiece>();
        int width=bitmap.getWidth();
        int height=bitmap.getHeight();

        int pieceWidth=Math.min(width,height)/piece;
        int pieceHeight=Math.max(width,height)/piece;
        for(int i=0;i<piece;i++){
            for(int j=0;j<piece;j++){
                Log.i("tapfuns","height:"+height+",width:"+width+",pieceWidth:"+pieceWidth);
                ImagePiece imagePiece=new ImagePiece();
                imagePiece.setIndex(j+i*piece);
                int x=j*pieceWidth;
                int y=i*pieceHeight;
                imagePiece.setBitmap(Bitmap.createBitmap(bitmap,x,y,pieceWidth,pieceHeight));
                imagePieces.add(imagePiece);
            }
        }
            return imagePieces;
    }
}
