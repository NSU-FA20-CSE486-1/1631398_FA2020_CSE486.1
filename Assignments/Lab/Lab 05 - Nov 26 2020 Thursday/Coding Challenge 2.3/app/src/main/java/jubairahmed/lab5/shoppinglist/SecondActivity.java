package jubairahmed.lab5.shoppinglist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {
    public static final String EXTRA_ITEMS = "jubairahmed.lab4.shoppinglist.extra.ITEMS";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    }

    public void selectItem(View view) {
        Intent return_items_intent = new Intent();

        switch (view.getId()){
            case R.id.button_butter:
                return_items_intent.putExtra(EXTRA_ITEMS, "Butter"); setResult(RESULT_OK, return_items_intent); finish();
                break;
            case R.id.button_oil:
                return_items_intent.putExtra(EXTRA_ITEMS, "Oil"); setResult(RESULT_OK, return_items_intent); finish();
                break;
            case R.id.button_milk:
                return_items_intent.putExtra(EXTRA_ITEMS, "Milk"); setResult(RESULT_OK, return_items_intent); finish();
                break;
            case R.id.button_eggs:
                return_items_intent.putExtra(EXTRA_ITEMS, "Eggs"); setResult(RESULT_OK, return_items_intent); finish();
                break;
            case R.id.button_daal:
                return_items_intent.putExtra(EXTRA_ITEMS, "Daal"); setResult(RESULT_OK, return_items_intent); finish();
                break;
            case R.id.button_rice:
                return_items_intent.putExtra(EXTRA_ITEMS, "Rice"); setResult(RESULT_OK, return_items_intent); finish();
                break;
            case R.id.button_wheat:
                return_items_intent.putExtra(EXTRA_ITEMS, "Wheat Flour"); setResult(RESULT_OK, return_items_intent); finish();
                break;
            case R.id.button_bread:
                return_items_intent.putExtra(EXTRA_ITEMS, "Bread"); setResult(RESULT_OK, return_items_intent); finish();
                break;
            case R.id.button_sugar:
                return_items_intent.putExtra(EXTRA_ITEMS, "Sugar"); setResult(RESULT_OK, return_items_intent); finish();
                break;
            case R.id.button_salt:
                return_items_intent.putExtra(EXTRA_ITEMS, "Salt"); setResult(RESULT_OK, return_items_intent); finish();
                break;
            default:
                Toast.makeText(SecondActivity.this, "There was an error", Toast.LENGTH_LONG).show();
                break;
        }

    }
}
