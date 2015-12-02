package com.m2i.formation.media.services;

import com.m2i.formation.media.entities.*;

public interface IMainService {

	void addAuthorToMedia(Author a, int mediaId) throws ServiceException;
	
	void addMedia(Media m) throws ServiceException;

}