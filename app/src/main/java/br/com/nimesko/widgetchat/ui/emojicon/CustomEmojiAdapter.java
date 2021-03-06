package br.com.nimesko.widgetchat.ui.emojicon;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.rockerhieu.emojicon.EmojiconTextView;
import com.rockerhieu.emojicon.emoji.Emojicon;

import java.util.List;

public class CustomEmojiAdapter extends ArrayAdapter<Emojicon> {

    public CustomEmojiAdapter(Context context, List<Emojicon> data) {
        super(context, com.rockerhieu.emojicon.R.layout.emojicon_item, data);
    }

    public CustomEmojiAdapter(Context context, Emojicon[] data) {
        super(context, com.rockerhieu.emojicon.R.layout.emojicon_item, data);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = convertView;

        if(convertView == null) {
            v = View.inflate(getContext(), com.rockerhieu.emojicon.R.layout.emojicon_item, null);
            CustomEmojiAdapter.ViewHolder emoji = new CustomEmojiAdapter.ViewHolder();
            emoji.icon = (EmojiconTextView) v.findViewById(com.rockerhieu.emojicon.R.id.emojicon_icon);
            emoji.icon.setUseSystemDefault(false);
            v.setTag(emoji);
        }

        Emojicon emoji1 = getItem(position);
        CustomEmojiAdapter.ViewHolder holder = (CustomEmojiAdapter.ViewHolder)v.getTag();
        holder.icon.setText(emoji1.getEmoji());

        return v;
    }

    private static class ViewHolder {
        private EmojiconTextView icon;
    }

}