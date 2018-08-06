package data;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import pl.preclaw.fiche.R;

public class ClassListHolder extends RecyclerView.ViewHolder {
    protected ImageView imageView;
    protected TextView className;
    protected TextView classDescr;
    protected TextView classLink;
    protected TextView classClasses;
    protected TextView classLanguage;
    public ClassListHolder(View itemView) {
        super(itemView);


        this.imageView = itemView.findViewById(R.id.ClassImage);
        this.className = itemView.findViewById(R.id.ClassName);
        this.classDescr = itemView.findViewById(R.id.ClassDescription);
        this.classLink = itemView.findViewById(R.id.ClassLink);
        this.classClasses = itemView.findViewById(R.id.ClassNumber);
        this.classLanguage = itemView.findViewById(R.id.ClassLanguage);
    }
}
