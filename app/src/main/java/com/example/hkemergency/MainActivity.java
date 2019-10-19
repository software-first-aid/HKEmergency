package com.example.hkemergency;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;

import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.graphics.drawable.DrawableCompat;


public class MainActivity extends Activity implements View.OnClickListener
{
    private static int WHITE_COLOR  = Color.parseColor( "#ffffff" );
    private static int PURPLE_COLOR = Color.parseColor( "#8a4edf" );
    private GridLayout gridBtnTab;

    /** Called when the activity is first created. */
    @Override
    public void onCreate( Bundle savedInstanceState )
    {
        super.onCreate(savedInstanceState);
        setContentView( R.layout.activity_main );

        gridBtnTab = findViewById( R.id.nav_grid_wrapper );
        int childCount = gridBtnTab.getChildCount();
        for ( int i = 0; i < childCount; ++i )
        {
            Button btn = (Button) gridBtnTab.getChildAt( i );
            btn.setOnClickListener( this );
        }

    }


    public void changeButtonColor( Button btn, int color )
    {
        int btnId = this.getResources().getIdentifier( btn.toString(), "layout", this.getPackageName() );
        Drawable unwrappedDrawable = AppCompatResources.getDrawable( this, btnId );
        Drawable wrappedDrawable = DrawableCompat.wrap( unwrappedDrawable );
        DrawableCompat.setTint( wrappedDrawable, color );
        btn.setTextColor( color );
    }


    public void onClick( View v )
    {
        // reset the button to white
        for ( int i = 0; i < gridBtnTab.getChildCount(); ++i )
        {
            Button btn = (Button) gridBtnTab.getChildAt( i );
            changeButtonColor( btn, WHITE_COLOR );
        }
        switch( v.getId( ) )
        {
            case R.id.mapButton: {
                Button b = findViewById( R.id.mapButton );
                changeButtonColor( b, PURPLE_COLOR );
                break;
            }
            case R.id.homeButton: {
                Button b = findViewById( R.id.homeButton );
                changeButtonColor( b, PURPLE_COLOR );
                break;
            }
            case R.id.alertButton: {
                Button b = findViewById( R.id.alertButton );
                changeButtonColor( b, PURPLE_COLOR );
                break;
            }
        }
    }

}
