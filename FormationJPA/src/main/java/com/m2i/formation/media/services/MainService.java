package com.m2i.formation.media.services;

import com.m2i.formation.media.entities.*;
import com.m2i.formation.media.repositories.*;

public class MainService implements IMainService {
	
	private MediaRepository mediaRepository;
	private AuthorRepository authorRepository;
	
	@Override
	public void addAuthorToMedia(Author a, int mediaId) throws ServiceException {
		
		Media m = mediaRepository.getById(mediaId);
		if(m != null) {
			if(!m.getAuthors().contains(a)){
				m.getAuthors().add(a);
				mediaRepository.getTransaction();
				mediaRepository.save(m);
				mediaRepository.commit();
			} else {
				throw new ServiceException("Author already associate with the media");
			}
		} else {
			throw new ServiceException("The media does not exist");
		}
	}

	public AuthorRepository getAuthorRepository() {
		return authorRepository;
	}

	public void setAuthorRepository(AuthorRepository authorRepository) {
		this.authorRepository = authorRepository;
	}

	public MediaRepository getMediaRepository() {
		return mediaRepository;
	}

	public void setMediaRepository(MediaRepository mediaRepository) {
		this.mediaRepository = mediaRepository;
	}

	@Override
	public void addMedia(Media m) throws ServiceException {
		// TODO Auto-generated method stub
		mediaRepository.getTransaction();
		mediaRepository.save(m);
		mediaRepository.commit();
	}
	
}
