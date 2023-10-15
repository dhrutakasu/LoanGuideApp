package com.info.aadhaarpeloan.guideinfoapp.LoanUi.LoanAdapter;

import android.content.Context;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.info.aadhaarpeloan.guideinfoapp.LoanModels.FAQsModel;
import com.info.aadhaarpeloan.guideinfoapp.R;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class DocumentListAdapter extends RecyclerView.Adapter<DocumentListAdapter.MyViewHolder> {
    private final Context context;
    private final ArrayList<String> faQsDetails;

    public DocumentListAdapter(Context context, ArrayList<String> faQsDetails) {
        this.context = context;
        this.faQsDetails = faQsDetails;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.layout_faqs_data, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.TvFAQsTitle.setTextColor(context.getResources().getColor(R.color.app_color));
        holder.TvFAQsTitle.setText(faQsDetails.get(position).toString());
        holder.TvFAQsDec.setVisibility(View.GONE);
    }

    @Override
    public int getItemCount() {
        return faQsDetails.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private final TextView TvFAQsTitle;
        private final TextView TvFAQsDec;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            TvFAQsTitle = itemView.findViewById(R.id.TvFAQsTitle);
            TvFAQsDec = itemView.findViewById(R.id.TvFAQsDec);
        }
    }
}
