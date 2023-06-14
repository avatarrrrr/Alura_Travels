package br.com.alura.aluraviagens.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import java.math.BigDecimal;

public class PackageModel implements Parcelable {

    private final String location;
    private final String image;
    private final int days;
    private final BigDecimal price;

    public PackageModel(String location, String image, int days, BigDecimal price) {
        this.location = location;
        this.image = image;
        this.days = days;
        this.price = price;
    }

    private PackageModel(Parcel parcel) {
        this.location = parcel.readString();
        this.image = parcel.readString();
        this.days = parcel.readInt();
        this.price = (BigDecimal) parcel.readValue(BigDecimal.class.getClassLoader());
    }

    public String getLocation() {
        return location;
    }

    public String getImage() {
        return image;
    }

    public int getDays() {
        return days;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public static final Parcelable.Creator<PackageModel>
            CREATOR = new Parcelable.Creator<PackageModel>() {

        public PackageModel createFromParcel(Parcel in) {
            return new PackageModel(in);
        }

        public PackageModel[] newArray(int size) {
            return new PackageModel[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeString(location);
        dest.writeString(image);
        dest.writeInt(days);
        dest.writeValue(price);
    }

}