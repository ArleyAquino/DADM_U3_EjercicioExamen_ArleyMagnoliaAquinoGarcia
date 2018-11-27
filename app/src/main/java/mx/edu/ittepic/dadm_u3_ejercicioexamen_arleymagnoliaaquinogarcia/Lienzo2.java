package mx.edu.ittepic.dadm_u3_ejercicioexamen_arleymagnoliaaquinogarcia;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.CountDownTimer;
import android.view.MotionEvent;
import android.view.View;

public class Lienzo2 extends View {
    Main2Activity p2;
    Imagen2 fondo, again;


    public Lienzo2(Context context) {
        super(context);
        p2 = (Main2Activity) context;
        fondo = new Imagen2(R.drawable.iniciarjuego, 0, 0, this);
    }

    protected void onDraw(Canvas c) {
        super.onDraw(c);
        Paint p = new Paint();

        fondo.pintar(c, p);

    }

    public boolean onTouchEvent(MotionEvent e) {
        float xp = e.getX();
        float yp = e.getY();

        switch (e.getAction()) {
            case MotionEvent.ACTION_DOWN:
                if (fondo.estaEnArea(xp, yp)) {
                    Intent otraVentan=new Intent(p2, MainActivity.class);
                    p2.startActivity(otraVentan);
                }

                break;
        }
        return true;
    }
}
