package com.m2i.formation.media.services;

import com.m2i.formation.media.entities.*;
import com.m2i.formation.media.repositories.*;

public class MainService implements IMainService {
	
	private MediaRepository mediaRepository;
	private AuthorRepository authorRepository;
	
	/* (non-Javadoc)
	 * @see com.m2i.formation.media.services.IMainService#addAuthorToMedia(com.m2i.formation.media.entities.Author, int)
	 */
	@Override
	public void addAuthorToMedia(Author a, int mediaId) throws ServiceException {
		
		mediaRepository = new MediaRepository();
		mediaRepository.setEntityManager(EMFSingleton.getEmf().createEntityManager());
		
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
	
}
