package cn.hl.bean;

public class File {
	private int fileId;
	private String fileName;
	private String url;
	
	public File() {
		// TODO Auto-generated constructor stub
	}

	public File(int fileId, String fileName, String url) {
		super();
		this.fileId = fileId;
		this.fileName = fileName;
		this.url = url;
	}

	public int getFileId() {
		return fileId;
	}

	public void setFileId(int fileId) {
		this.fileId = fileId;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	
}
