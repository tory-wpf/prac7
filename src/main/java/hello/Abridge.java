package hello;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Abridge {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String hash;
	private String originalUrl;

	public String getPath2site() {
		return path2site;
	}

	private String path2site = "http://localhost:8080/abridgeUrl/";

	public Abridge(String originalUrl, String hash) {
		this.originalUrl = originalUrl;
		this.hash = hash;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getHash() {
		return hash;
	}

	public void setHash(String hash) {
		this.hash = hash;
	}

	public String getOriginalUrl() {
		return originalUrl;
	}

	public void setOriginalUrl(String originalUrl) {
		this.originalUrl = originalUrl;
	}

	public Abridge() {
	}




}
