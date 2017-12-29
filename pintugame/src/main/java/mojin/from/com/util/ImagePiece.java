package mojin.from.com.util;

import android.graphics.Bitmap;

/**
 * Created by Administrator on 2017/12/26.
 */
public class ImagePiece {
    private int index;
    private Bitmap bitmap;

    public Bitmap getBitmap() {
        return bitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    @Override
    public String toString() {
        return "ImagePiece{" +
                "bitmap=" + bitmap +
                ", index=" + index +
                '}';
    }
    public ImagePiece(){

    }
    public ImagePiece(Bitmap bitmap, int index) {
        this.bitmap = bitmap;
        this.index = index;
    }
}
