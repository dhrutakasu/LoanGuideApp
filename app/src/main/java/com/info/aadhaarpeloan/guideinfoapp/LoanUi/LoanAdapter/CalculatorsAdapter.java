package com.info.aadhaarpeloan.guideinfoapp.LoanUi.LoanAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.info.aadhaarpeloan.guideinfoapp.LoanModels.CalculatorModel;
import com.info.aadhaarpeloan.guideinfoapp.R;

import java.util.ArrayList;

public class CalculatorsAdapter extends RecyclerView.Adapter<CalculatorsAdapter.MyViewHolder> {
    private final Context context;
    private final ArrayList<CalculatorModel> calculatorModels;
    private final setCalculatorClick click;

    public CalculatorsAdapter(Context context, ArrayList<CalculatorModel> calculatorModels, setCalculatorClick calculatorClick) {
        this.context = context;
        this.calculatorModels = calculatorModels;
        this.click = calculatorClick;
    }

    @Override
    public MyViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.layout_item_calculator, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder( MyViewHolder holder, int position) {
        holder.IvCalIcon.setImageResource(calculatorModels.get(position).getCalIcon());
        holder.TvCalName.setText(calculatorModels.get(position).getCalName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                click.CalculatorClick(position);
            }
        });
    }

    public interface setCalculatorClick {
        void CalculatorClick(int pos);
    }

    @Override
    public int getItemCount() {
        return calculatorModels.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private final ImageView IvCalIcon;
        private final TextView TvCalName;

        public MyViewHolder( View itemView) {
            super(itemView);
            IvCalIcon = itemView.findViewById(R.id.IvCalIcon);
            TvCalName = itemView.findViewById(R.id.TvCalName);
        }
    }
}
