// Java Program to Illustrate Creation of Simple POJO Class
package com.Song;
// Importing required classes
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "song")

// POJO class
public class Song {

	@Id @Column(name = "songId") private int id;

	@Column(name = "songName") private String songName;

	@Column(name = "singer") private String singer;

	public int getId() { return id; }

	public void setId(int id) { this.id = id; }

	public String getSongName() { return songName; }

	public void setSongName(String songName)
	{
		this.songName = songName;
	}

	public String getSinger() { return singer; }

	public void setSinger(String singer)
	{
		this.singer = singer;
	}


	@Override
	public String toString() {
		return "{" +
			" id='" + getId() + "'" +
			", songName='" + getSongName() + "'" +
			", singer='" + getSinger() + "'" +
			"}";
	}

}
