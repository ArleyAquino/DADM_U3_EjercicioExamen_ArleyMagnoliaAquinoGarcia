package mx.edu.ittepic.dadm_u3_ejercicioexamen_arleymagnoliaaquinogarcia;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.CountDownTimer;



public class Imagen {
    private Bitmap icono;
    private float x, y;
    int puntos=0;
    private boolean visible;
    CountDownTimer timer,timer2, t, t2, t3, timer3, timer4, timer5;
    private float px, desplazamientoy,  desplazamx,  desplazamy, desplazy, desplazay, balax, desy, desy2, desy3, desy4;


    public Imagen(int resource, float _x, float _y, final Lienzo l ){
        icono =BitmapFactory.decodeResource(l.getResources(), resource);
        x=_x;
        y=_y;
        visible = true;
        timer =new CountDownTimer(1000,50) {
            @Override
            public void onTick(long millisUntilFinished) {
                if(y<=-70){
                    y=922;
                    x=l.px;
                }
                else{
                    y-=desplazamientoy;
                }
                l.invalidate();
            }

            @Override
            public void onFinish() {
                start();
            }
        };
        t =new CountDownTimer(1000,100) {
            @Override
            public void onTick(long millisUntilFinished) {
                /*x+=desplazamx;
                y+=desplazamy;
                if(x>= l.getWidth()-70 || x<=0 ){
                    desplazamx *=-1;
                }
                if(y>=l.getHeight()-70 || y<=0){
                    desplazamy *=-1;
                }
                l.invalidate();*/
                if(y>=l.getWidth()+100){
                    y=0;
                    x=100;
                }
                else{
                    y+=desplazamy;
                }
                l.invalidate();
            }

            @Override
            public void onFinish() {
                start();
            }
        };
        t2 =new CountDownTimer(1000,100) {
            @Override
            public void onTick(long millisUntilFinished) {
                if(y>=l.getWidth()+100){
                    y=0;
                    x=650;
                }
                else{
                    y+=desplazay;
                }
                l.invalidate();
            }

            @Override
            public void onFinish() {
                start();
            }
        };
        t3 =new CountDownTimer(1000,100) {
            @Override
            public void onTick(long millisUntilFinished) {
                if(y>=l.getWidth()+100){
                    y=0;
                    x=400;
                }
                else{
                    y+=desplazy;
                }
                l.invalidate();
            }

            @Override
            public void onFinish() {
                start();
            }
        };
        timer2 =new CountDownTimer(1000,10) {
            @Override
            public void onTick(long millisUntilFinished) {
                if(y>=l.getHeight()){
                    y=l.pbya1;
                    x=balax;
                }
                else{
                    y+=desy2;
                }
                l.invalidate();
            }

            @Override
            public void onFinish() {
                start();
            }
        };
        timer3 =new CountDownTimer(1000,10) {
            @Override
            public void onTick(long millisUntilFinished) {
                if(y>=l.getHeight()){
                    y=l.pbya2;
                    x=balax;
                }
                else{
                    y+=desy3;
                }
                l.invalidate();
            }

            @Override
            public void onFinish() {
                start();
            }
        };
        timer4 =new CountDownTimer(1000,10) {
            @Override
            public void onTick(long millisUntilFinished) {
                if(y>=l.getHeight()){
                    y=l.pbya3;
                    x=balax;
                }
                else{
                    y+=desy4;
                }
                l.invalidate();
            }

            @Override
            public void onFinish() {
                start();
            }
        };


    }
    public boolean esVisible(){return visible;}
    public void hacerVisible(boolean v){
        visible=v;
    }
    public  void pintar (Canvas c, Paint p){
        if (visible) c.drawBitmap(icono, x, y, p);

    }

    public boolean estaEnArea(float xp, float yp){
        if (!visible) return false;
        float x2, y2;
        x2=x+icono.getWidth();
        y2=y+icono.getHeight();

        if(xp>=x && xp<x2){
            if(yp>=y && yp<y2){

                return true;
            }
        }
        return false;
    }
    public void mover(float xp, float yp){
        x=xp-(icono.getWidth()/2);
        //y=yp-(icono.getHeight()/2);
    }
    public boolean colision (Imagen objetoB){
        float x2=x+icono.getWidth();
        float y2=y+icono.getHeight();

        if(objetoB.estaEnArea(x2, y)){
            return true;
        }
        if(objetoB.estaEnArea(x, y)){
            return true;
        }

        if(objetoB.estaEnArea(x2, y2)){
            return true;
        }
        if(objetoB.estaEnArea(x, y2)){
            return true;
        }
        return false;
    }
    public int getWidth (){
        int ancho=icono.getWidth();
        return ancho;
    }
    public int getHeight (){
        int alto=icono.getHeight();
        return alto;
    }
    public void moverB(float desy){
        desplazamientoy=desy;
        timer.start();
    }
    public void moverA( float desplazay){
        desplazamy=desplazay;
        t.start();
    }
    public void moverA2( float desplazy){
        desplazay=desplazy;
        t2.start();
    }
    public void moverA3( float desplazyy){
        desplazy=desplazyy;
        t3.start();
    }
    public void moverB2(float desyy, float bx){
        desy2=desyy;
        balax=bx;
        timer2.start();
    }
    public void moverB3(float desyy, float bx){
        desy3=desyy;
        balax=bx;
        timer3.start();
    }
    public void moverB4(float desyy, float bx){
        desy4=desyy;
        balax=bx;
        timer4.start();
    }
    public float getX(){
        return x;
    }
    public float getY(){
        return y;
    }


}
