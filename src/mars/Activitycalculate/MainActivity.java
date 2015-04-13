package mars.Activitycalculate;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

    private TextView factor;
    private EditText factor1;
    private EditText factor2;
    private Button result;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        factor = (TextView)findViewById(R.id.factor);
        factor1 = (EditText)findViewById(R.id.factor1);
        factor2 = (EditText)findViewById(R.id.factor2);
        result = (Button)findViewById(R.id.result);
        factor.setText(R.string.factor);
        result.setText(R.string.result);
        //绑定一个监听器到该按钮
        result.setOnClickListener(new onResultClickListener());
    }
   
    //该函数其实是一个回调函数，但在系统中按下了menu按钮时会自动调用这个函数
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //要在返回代码之前加入
        menu.add(0, 1, 1, R.string.exit);
        menu.add(0, 2, 2, R.string.about);
        return super.onCreateOptionsMenu(menu);    
    }
   
    //菜单项选择函数重写
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if( 1 == item.getItemId() )
            finish();
        return super.onOptionsItemSelected(item);
    }


    //创建一个监听器
    class onResultClickListener implements OnClickListener{

        public void onClick(View v) {
            //获取2个edit输入的数字
            String factor1_str = factor1.getText().toString();
            String factor2_str = factor2.getText().toString();
            //建立intent，并将数据传入，且激活ResultActivity
            Intent intent = new Intent();
            intent.putExtra("factor1", factor1_str);
            intent.putExtra("factor2", factor2_str);
            intent.setClass(MainActivity.this, ResultActivity.class);
            //启动intent
            MainActivity.this.startActivity(intent);
        }
      
    }
    


}