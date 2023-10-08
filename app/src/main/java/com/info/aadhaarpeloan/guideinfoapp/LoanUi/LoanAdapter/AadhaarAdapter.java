package com.info.aadhaarpeloan.guideinfoapp.LoanUi.LoanAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.info.aadhaarpeloan.guideinfoapp.R;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AadhaarAdapter extends RecyclerView.Adapter<AadhaarAdapter.MyViewHolder> {
    private final Context context;
    private final ArrayList<String> faQsDetails;
    private final setAadhaarClick click;

    public AadhaarAdapter(Context context, ArrayList<String> faQsDetails, setAadhaarClick aadhaarClick) {
        this.context = context;
        this.faQsDetails = faQsDetails;
        this.click = aadhaarClick;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.layout_aadhaar_data, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.TvAadhaarText.setText(faQsDetails.get(position).toString());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                click.LoanClick(position);
            }
        });
    }

    public interface setAadhaarClick {
        void LoanClick(int pos);
    }

    @Override
    public int getItemCount() {
        return faQsDetails.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private final TextView TvAadhaarText;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            TvAadhaarText = itemView.findViewById(R.id.TvAadhaarText);
        }
    }
}
