package org.lenndi.umtapo.service.specific.implementation;

import org.lenndi.umtapo.dao.LibraryDao;
import org.lenndi.umtapo.dto.LibraryDto;
import org.lenndi.umtapo.entity.Library;
import org.lenndi.umtapo.mapper.LibraryMapper;
import org.lenndi.umtapo.service.generic.AbstractGenericService;
import org.lenndi.umtapo.service.specific.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

/**
 * Library service implementation.
 */
@Service
public class LibraryServiceImpl extends AbstractGenericService<Library, Integer> implements LibraryService {

    private final LibraryMapper libraryMapper;
    private final LibraryDao libraryDao;

    /**
     * Instantiates a new Library service.
     *
     * @param libraryMapper the library mapper
     * @param libraryDao    the library dao
     */
    @Autowired
    public LibraryServiceImpl(LibraryMapper libraryMapper, LibraryDao libraryDao) {
        Assert.notNull(libraryMapper, "Argument libraryMapper cannot be null");

        this.libraryMapper = libraryMapper;
        this.libraryDao = libraryDao;
    }

    @Override
    public LibraryDto saveDto(LibraryDto libraryDto) {
        Library library = this.libraryMapper.mapLibraryDtoToLibrary(libraryDto);
        library = this.save(library);

        return this.libraryMapper.mapLibraryToLibraryDto(library);
    }

    @Override
    public LibraryDto findOneDto(Integer id) {
        Library library = this.findOne(id);

        return this.libraryMapper.mapLibraryToLibraryDto(library);
    }

    @Override
    public List<LibraryDto> findAllDto() {
        return mapLibrariesToLibrariesDTO(this.findAll());
    }

    @Override
    public List<LibraryDto> findAllExternal() {
        return this.mapLibrariesToLibrariesDTO(this.libraryDao.findByExternalTrue());
    }

    @Override
    public List<LibraryDto> findAllPartner() {
        return this.mapLibrariesToLibrariesDTO(this.libraryDao.findByExternalFalse());
    }

    @Override
    public Library mapLibraryDtoToLibrary(LibraryDto libraryDto) {
        return this.libraryMapper.mapLibraryDtoToLibrary(libraryDto);
    }


    private LibraryDto mapLibraryToLibraryDto(Library library) {
        return this.libraryMapper.mapLibraryToLibraryDto(library);
    }

    private List<Library> mapLibrariesDtoToLibraries(List<LibraryDto> librariesDto) {
        List<Library> libraries = new ArrayList<>();
        librariesDto.forEach(LibraryDto -> libraries.add(mapLibraryDtoToLibrary(LibraryDto)));

        return libraries;
    }

    private List<LibraryDto> mapLibrariesToLibrariesDTO(List<Library> libraries) {
        List<LibraryDto> librariesDto = new ArrayList<>();
        libraries.forEach(Library -> librariesDto.add(mapLibraryToLibraryDto(Library)));

        return librariesDto;
    }
}
