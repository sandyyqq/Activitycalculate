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
        //��һ�����������ð�ť
        result.setOnClickListener(new onResultClickListener());
    }
   
    //�ú�����ʵ��һ���ص�����������ϵͳ�а�����menu��ťʱ���Զ������������
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //Ҫ�ڷ��ش���֮ǰ����
        menu.add(0, 1, 1, R.string.exit);
        menu.add(0, 2, 2, R.string.about);
        return super.onCreateOptionsMenu(menu);    
    }
   
    //�˵���ѡ������д
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if( 1 == item.getItemId() )
            finish();
        return super.onOptionsItemSelected(item);
    }


    //����һ��������
    class onResultClickListener implements OnClickListener{

        public void onClick(View v) {
            //��ȡ2��edit���������
            String factor1_str = factor1.getText().toString();
            String factor2_str = factor2.getText().toString();
            //����intent���������ݴ��룬�Ҽ���ResultActivity
            Intent intent = new Intent();
            intent.putExtra("factor1", factor1_str);
            intent.putExtra("factor2", factor2_str);
            intent.setClass(MainActivity.this, ResultActivity.class);
            //����intent
            MainActivity.this.startActivity(intent);
        }
      
    }
    


}