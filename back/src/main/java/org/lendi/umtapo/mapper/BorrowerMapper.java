package org.lendi.umtapo.mapper;


import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.lendi.umtapo.dto.BorrowerDto;
import org.lendi.umtapo.entity.Borrower;
import org.springframework.stereotype.Component;

/**
 * Borrower mapper générique
 * <p>
 * Created by axel on 05/12/16.
 */
@Component
public class BorrowerMapper extends ConfigurableMapper {

    private final static MapperFacade mapper;

    static {
        final MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
        mapperFactory.classMap(Borrower.class, BorrowerDto.class).byDefault().register();
        mapper = mapperFactory.getMapperFacade();
    }


    public BorrowerMapper() {
    }


    public BorrowerDto mapBorrowerToBorrowerDto(Borrower borrower) {
        BorrowerDto borrowerDto = mapper.map(borrower, BorrowerDto.class);
        return borrowerDto;
    }


    public Borrower mapBorrowerDtoToBorrower(BorrowerDto borrowerDto) {
        Borrower borrower = mapper.map(borrowerDto, Borrower.class);
        return borrower;
    }
}