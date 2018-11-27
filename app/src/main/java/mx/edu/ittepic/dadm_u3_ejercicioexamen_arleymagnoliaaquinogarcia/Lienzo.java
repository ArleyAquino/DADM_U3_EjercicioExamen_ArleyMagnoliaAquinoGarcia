package mx.edu.ittepic.dadm_u3_ejercicioexamen_arleymagnoliaaquinogarcia;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.os.CountDownTimer;
import android.view.View;

public class Lienzo extends View {
    MainActivity p1;
    Bitmap fondos;
    int puntos=0, i=0;
    Imagen nave, fondo, ganador,perdedor,otravez, alien, puntero, bala, alien2, bala2, alien3, bala3, bala4, bala5, conta;
    int xb, yb;
    float px, pbya1, pbya2,pbya3;
    CountDownTimer t;
    public Lienzo(Context context) {
        super(context);
        p1 = (MainActivity) context;
        fondo = new Imagen(R.drawable.fondoestrellas, 0,0, this);
        nave = new Imagen(R.drawable.nave, 342,950, this);
        ganador = new Imagen(R.drawable.ganaste, 0,0, this);
        perdedor = new Imagen(R.drawable.perdiste, 0,0, this);
        otravez = new Imagen(R.drawable.otravez, 650,1000, this);
        px=342+(nave.getWidth()/2)-4;
        alien = new Imagen(R.drawable.alien, 100,200, this);
        alien2 = new Imagen(R.drawable.alien, 650,450, this);
        alien3 = new Imagen(R.drawable.alien, 400,650, this);
        bala=new Imagen(R.drawable.balanave,342+(nave.getWidth()/2)-20,922, this);

        bala2=new Imagen(R.drawable.balaalien,100+(alien.getWidth()/2),200+alien.getHeight(), this);
        bala3=new Imagen(R.drawable.balaalien,650+(alien.getWidth()/2),450+alien.getHeight(), this);
        bala4=new Imagen(R.drawable.balaalien,400+(alien.getWidth()/2),650+alien.getHeight(), this);
        puntero=null;

        bala.moverB(25);
        bala2.moverB2(8,100+(alien.getWidth()/2)-20);
        bala3.moverB3(10,650+(alien.getWidth()/2)-20);
        bala4.moverB4(8,400+(alien.getWidth()/2)-20);
        alien.moverA(8);
        alien2.moverA2(10);
        alien3.moverA3(8);

        t =new CountDownTimer(1000,100) {
            @Override
            public void onTick(long millisUntilFinished) {
                puntos+=1;
                invalidate();
            }

            @Override
            public void onFinish() {
                start();
            }
        };t.start();

    }
    protected void onDraw (Canvas c){
        super.onDraw(c);
        Paint p= new Paint();

        if(bala.colision(alien)){
            alien.hacerVisible(false);
            bala2.hacerVisible(false);
            i+=1;
        }
        if(bala.colision(alien2)){
            alien2.hacerVisible(false);
            bala3.hacerVisible(false);
            i+=1;
        }
        if(bala.colision(alien3)){
            alien3.hacerVisible(false);
            bala4.hacerVisible(false);
            i+=1;
        }
        if(i>=3){
            //nave.hacerVisible(false); bala.hacerVisible(false); fondo.hacerVisible(false);
            ganador.pintar(c,p);
            t.cancel();
            p.setTextSize(50); p.setColor(Color.WHITE); p.setStyle(Paint.Style.STROKE);
            c.drawText("Puntos: "+puntos,getWidth()/2-100,getHeight()/2+200, p);

            otravez.pintar(c,p);

        }else{
            p.setTextSize(40); p.setColor(Color.WHITE); p.setStyle(Paint.Style.STROKE);
            c.drawText("Puntos: "+puntos,getWidth()-250,getHeight()-25, p);
            fondo.pintar(c,p);

            nave.pintar(c,p);
            alien.pintar(c,p);
            alien2.pintar(c,p);
            alien3.pintar(c,p);
            bala.pintar(c,p); bala2.pintar(c,p);bala3.pintar(c,p);bala4.pintar(c,p);
        }
        pbya1=alien.getY()+(alien.getHeight());
        pbya2=alien2.getY()+(alien.getHeight());
        pbya3=alien3.getY()+(alien.getHeight());


    }
    public boolean onTouchEvent (MotionEvent e){
        float xp=e.getX();
        float yp=e.getY();

        switch(e.getAction()){
            case MotionEvent.ACTION_DOWN:
                if(nave.estaEnArea(xp,yp)){
                    puntero=nave;
                    }
                if(otravez.estaEnArea(xp,yp)){
                    //puntero=otravez;
                    Intent otraVentana=new Intent(p1, Main2Activity.class);
                    p1.startActivity(otraVentana);
                }
                break;
            case MotionEvent.ACTION_MOVE:
                if(puntero!=null){
                    if(puntero==nave){
                        puntero.mover(xp,yp);
                        px=puntero.getX()+(nave.getWidth()/2)-20;
                    }

                     if(bala2.colision(puntero) && puntero==nave && bala2.esVisible()){
                         alien.hacerVisible(false);
                         bala2.hacerVisible(false);
                         nave.hacerVisible(false);
                        t.cancel();
                        Intent otraVentana=new Intent(p1, Main3Activity.class);
                        otraVentana.putExtra("puntos",puntos);
                        p1.startActivity(otraVentana);
                    }
                    if(bala3.colision(puntero) && puntero==nave && bala3.esVisible()){
                        alien2.hacerVisible(false);
                        bala3.hacerVisible(false);
                        nave.hacerVisible(false);
                        t.cancel();
                        Intent otraVentana=new Intent(p1, Main3Activity.class);
                        otraVentana.putExtra("puntos",puntos);
                        p1.startActivity(otraVentana);
                    }
                    if(bala4.colision(puntero) && puntero==nave && bala4.esVisible()){
                        alien3.hacerVisible(false);
                        bala4.hacerVisible(false);
                        nave.hacerVisible(false);
                        t.cancel();
                        Intent otraVentana=new Intent(p1, Main3Activity.class);
                        otraVentana.putExtra("puntos",puntos);
                        p1.startActivity(otraVentana);
                    }
                    if(alien.colision(puntero) && puntero==nave && alien.esVisible()){
                        alien.hacerVisible(false);
                        bala2.hacerVisible(false);
                        nave.hacerVisible(false);
                        t.cancel();
                        Intent otraVentana=new Intent(p1, Main3Activity.class);
                        otraVentana.putExtra("puntos",puntos);
                        p1.startActivity(otraVentana);
                    }
                    if(alien2.colision(puntero) && puntero==nave && alien2.esVisible()){
                        alien2.hacerVisible(false);
                        bala3.hacerVisible(false);
                        nave.hacerVisible(false);
                        t.cancel();
                        Intent otraVentana=new Intent(p1, Main3Activity.class);
                        otraVentana.putExtra("puntos",puntos);
                        p1.startActivity(otraVentana);
                    }
                    if(alien3.colision(puntero) && puntero==nave && alien3.esVisible()){
                        alien3.hacerVisible(false);
                        bala4.hacerVisible(false);
                        nave.hacerVisible(false);
                        t.cancel();
                        Intent otraVentana=new Intent(p1, Main3Activity.class);
                        otraVentana.putExtra("puntos",puntos);
                        p1.startActivity(otraVentana);
                    }

                }
                break;
            case MotionEvent.ACTION_UP:
                break;
        }
        invalidate();
        return true;
    }
}

