package com.abhijit.bookservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private Environment environment;
	
	@Autowired
	private BookRepository bookRepository;
	
	@Override
	public BookDto findById(long id) {
		BookEntity entity = bookRepository.findById(id).get();
		
		BookDto dto = new BookDto();
		dto.setId(entity.getId());
		dto.setName(entity.getName());
		dto.setPrice(entity.getPrice());
		dto.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
		
		return dto;
	}

}
