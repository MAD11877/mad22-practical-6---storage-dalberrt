package sg.edu.np.mad.madpractical6;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class UserViewHolder extends RecyclerView.ViewHolder {
    TextView name;
    TextView desc;
    ImageView icon;

    public UserViewHolder(View itemView)
    {
        super(itemView);
        name = itemView.findViewById(R.id.list_name);
        desc = itemView.findViewById(R.id.list_desc);
        icon = itemView.findViewById(R.id.list_icon);
    }
}
