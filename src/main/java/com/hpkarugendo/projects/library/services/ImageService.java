package com.hpkarugendo.projects.library.services;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.core.io.ClassPathResource;
import org.springframework.web.multipart.MultipartFile;

public class ImageService {
	private MultipartFile source;
	private String url, media;

	public ImageService() {
		super();
	}

	public ImageService(MultipartFile source, String media) {
		super();
		this.source = source;
		this.media = media;
	}

	public MultipartFile getSource() {
		return source;
	}

	public void setSource(MultipartFile source) {
		this.source = source;
	}

	public String getMedia() {
		return media;
	}

	public void setMedia(String media) {
		this.media = media;
	}

	public String getUrl() {
		saveImage();
		return url;
	}

	private void saveImage() {
		String ans = "src/main/resources/static/images/projects/library/" + media + "/";
		try {
			byte[] bytes = source.getBytes();
            Path path = Paths.get(ans + source.getOriginalFilename());
            Files.write(path, bytes);
			this.url = "/images/projects/library/" + media + "/" + source.getOriginalFilename();
		} catch (Exception e) {
			throw new RuntimeException("ERROR SAVING IMAGE. Error: " + e.getMessage());
		}

	}

	public void setUrl(String url) {
		this.url = url;
	}

}
