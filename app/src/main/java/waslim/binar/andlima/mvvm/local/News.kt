package waslim.binar.andlima.mvvm.local

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Entity
@Parcelize
data class News(
    @PrimaryKey(autoGenerate = true)
    var id: Int?,
    @ColumnInfo(name = "createdAt")
    var createdAt: String,
    @ColumnInfo(name = "description")
    var description: String,
    @ColumnInfo(name = "author")
    var author: String,
    @ColumnInfo(name = "image")
    var image: String,
    @ColumnInfo(name = "title")
    var title: String

) : Parcelable
