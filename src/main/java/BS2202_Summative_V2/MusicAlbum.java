package BS2202_Summative_V2;

import javax.persistence.*;

@Entity
public class MusicAlbum extends Item
{
    public MusicAlbum(int id, String title, String length, String type, int availableCopies, int copiesLoaned)
    {
        super(id, title, length, type, availableCopies, copiesLoaned);
    }

    public MusicAlbum() {

    }
}
