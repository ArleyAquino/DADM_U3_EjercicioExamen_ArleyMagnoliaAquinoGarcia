package mx.edu.ittepic.dadm_u3_ejercicioexamen_arleymagnoliaaquinogarcia;

import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

public class Lienzo3 extends View {
    Main3Activity p3;
    Imagen3 fondo, again;
    Lienzo li;
    int puntoss;


    public Lienzo3(Context context) {
        super(context);
        p3 = (Main3Activity) context;
        fondo = new Imagen3(R.drawable.perdiste, 0, 0, this);
        again = new Imagen3(R.drawable.otravez , 650,1000, this);
    }

    protected void onDraw(Canvas c) {
        super.onDraw(c);
        Paint p = new Paint();

        fondo.pintar(c, p);
        again.pintar(c,p);
        puntoss=p3.getIntent().getExtras().getInt("puntos");
        p.setTextSize(50); p.setColor(Color.WHITE); p.setStyle(Paint.Style.STROKE);
        c.drawText("Puntos: "+puntoss,getWidth()/2-100,getHeight()/2+200, p);


    }

    public boolean onTouchEvent(MotionEvent e) {
        float xp = e.getX();
        float yp = e.getY();

        switch (e.getAction()) {
            case MotionEvent.ACTION_DOWN:
                if (again.estaEnArea(xp, yp)) {
                    Intent otraVentanas=new Intent(p3, Main2Activity.class);
                    p3.startActivity(otraVentanas);
                }

                break;
        }
        return true;
    }
}