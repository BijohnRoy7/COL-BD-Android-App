package com.example.colbdapplication.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.example.colbdapplication.R;
import com.example.colbdapplication.models.ReportFooter;
import com.example.colbdapplication.models.ReportHeader;
import com.example.colbdapplication.models.ReportItem;
import com.example.colbdapplication.models.ReportMain;

import java.util.List;

public class ReportAdapter extends RecyclerView.Adapter {
//https://www.loopwiki.com/ui-ux-design/recyclerview-with-header-and-footer-android-example/

    //Declare List of Recyclerview Items
    List<ReportItem> recyclerViewItems;
    //Header Item Type
    private static final int HEADER_ITEM = 0;
    //Footer Item Type
    private static final int FOOTER_ITEM = 1;
    ////Food Item Type
    private static final int MAIN_ITEM = 2;
    Context mContext;

    private ReportItemClickListener reportItemClickListener;

    public ReportAdapter(List<ReportItem> recyclerViewItems, Context mContext) {
        this.recyclerViewItems = recyclerViewItems;
        this.mContext = mContext;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View row;
        Log.d("TAG", "onCreateViewHolder: "+viewType);
        //Check fot view Type inflate layout according to it
        if (viewType == HEADER_ITEM) {
            row = inflater.inflate(R.layout.single_report_item_header, parent, false);
            return new HeaderHolder(row);
        } else if (viewType == FOOTER_ITEM) {
            row = inflater.inflate(R.layout.single_report_item_footer, parent, false);
            return new FooterHolder(row);
        } else if (viewType == MAIN_ITEM) {
            row = inflater.inflate(R.layout.single_report_item_main, parent, false);
            return new MainItemHolder(row);

        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        ReportItem recyclerViewItem = recyclerViewItems.get(position);
        //Check holder instance to populate data  according to it
        if (holder instanceof HeaderHolder) {
            HeaderHolder headerHolder = (HeaderHolder) holder;
            ReportHeader header = (ReportHeader) recyclerViewItem;
            //set data
            /*headerHolder.texViewHeaderText.setText(header.getHeaderText());
            headerHolder.textViewCategory.setText(header.getCategory());
            Glide.with(mContext).load(header.getImageUrl()).into(headerHolder.imageViewHeader);*/

        } else if (holder instanceof FooterHolder) {
            FooterHolder footerHolder = (FooterHolder) holder;
            ReportFooter footer = (ReportFooter) recyclerViewItem;
            //set data
            /*footerHolder.texViewQuote.setText(footer.getQuote());
            footerHolder.textViewAuthor.setText(footer.getAuthor());
            Glide.with(mContext).load(footer.getImageUrl()).into(footerHolder.imageViewFooter);*/
            footerHolder.btSendEmail.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(mContext, "Sending Email", Toast.LENGTH_SHORT).show();
                    if (reportItemClickListener != null){
                        reportItemClickListener.onClickSendEmail(position);
                    }
                }
            });

            footerHolder.btCancel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(mContext, "Cancelled", Toast.LENGTH_SHORT).show();
                    if (reportItemClickListener != null){
                        reportItemClickListener.onClickCancel(position);
                    }
                }
            });

        } else if (holder instanceof MainItemHolder) {
            MainItemHolder mainItemHolder = (MainItemHolder) holder;
            ReportMain foodItem = (ReportMain) recyclerViewItem;
            //set data
            /*foodItemHolder.texViewFoodTitle.setText(foodItem.getTitle());
            foodItemHolder.texViewDescription.setText(foodItem.getDescription());
            foodItemHolder.textViewPrice.setText(foodItem.getPrice());
            Glide.with(mContext).load(foodItem.getImageUrl()).into(foodItemHolder.imageViewFood);
            //check food item is hot or not to set visibility of hot text on image
            if (foodItem.isHot())
                foodItemHolder.textViewIsHot.setVisibility(View.VISIBLE);
            else
                foodItemHolder.textViewIsHot.setVisibility(View.GONE);*/

        }

    }

    @Override
    public int getItemViewType(int position) {
        //here we can set view type
        ReportItem recyclerViewItem = recyclerViewItems.get(position);
        //if its header then return header item
        if (recyclerViewItem instanceof ReportHeader)
            return HEADER_ITEM;
            //if its Footer then return Footer item
        else if (recyclerViewItem instanceof ReportFooter)
            return FOOTER_ITEM;
            //if its FoodItem then return Food item
        else if (recyclerViewItem instanceof ReportMain)
            return MAIN_ITEM;
        else
            return super.getItemViewType(position);

    }

    @Override
    public int getItemCount() {
        return recyclerViewItems.size();
    }
    //Food item holder
    private class MainItemHolder extends RecyclerView.ViewHolder {
        /*TextView texViewFoodTitle, texViewDescription, textViewPrice, textViewIsHot;
        ImageView imageViewFood;*/

        MainItemHolder(View itemView) {
            super(itemView);
            /*texViewFoodTitle = itemView.findViewById(R.id.texViewFoodTitle);
            texViewDescription = itemView.findViewById(R.id.texViewDescription);
            imageViewFood = itemView.findViewById(R.id.imageViewFood);
            textViewPrice = itemView.findViewById(R.id.textViewPrice);
            textViewIsHot = itemView.findViewById(R.id.textViewIsHot);*/
        }
    }
    //header holder
    private class HeaderHolder extends RecyclerView.ViewHolder {
        /*TextView texViewHeaderText, textViewCategory;
        ImageView imageViewHeader;*/

        HeaderHolder(View itemView) {
            super(itemView);
            /*texViewHeaderText = itemView.findViewById(R.id.texViewHeaderText);
            textViewCategory = itemView.findViewById(R.id.textViewCategory);
            imageViewHeader = itemView.findViewById(R.id.imageViewHeader);*/
        }
    }
    //footer holder
    private class FooterHolder extends RecyclerView.ViewHolder {
        Button btSendEmail, btCancel;

        FooterHolder(View itemView) {
            super(itemView);
            btSendEmail = itemView.findViewById(R.id.bt_email_report_footer);
            btCancel = itemView.findViewById(R.id.bt_cancel_report_footer);

        }
    }


    public interface ReportItemClickListener{
        void onClickSendEmail(int position);
        void onClickCancel(int position);
    }

    public void setReportItemClickListener(ReportItemClickListener reportItemClickListener) {
        this.reportItemClickListener = reportItemClickListener;
    }
}
