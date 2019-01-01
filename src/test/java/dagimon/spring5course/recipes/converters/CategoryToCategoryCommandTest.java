package dagimon.spring5course.recipes.converters;

import dagimon.spring5course.recipes.commands.CategoryCommand;
import dagimon.spring5course.recipes.domain.Category;
import dagimon.spring5course.recipes.domain.UnitOfMeasure;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CategoryToCategoryCommandTest {

    private final static String OBJECT_ID = "1";
    private final static String OBJECT_DESC = "DESC";

    private CategoryToCategoryCommand converter;

    @Before
    public void setUp() throws Exception {
        converter = new CategoryToCategoryCommand();
    }

    @Test
    public void convertNull() {
        assertNull(converter.convert(null));
    }

    @Test
    public void convertEmpty() {
        assertNotNull(converter.convert(new Category()));
    }

    @Test
    public void convert() {
        //given
        Category objectToConvert = new Category();
        objectToConvert.setId(OBJECT_ID);
        objectToConvert.setDescription(OBJECT_DESC);

        //when
        CategoryCommand objectConverted = converter.convert(objectToConvert);

        //then
        assertNotNull(objectConverted);
        assertEquals(OBJECT_ID, objectConverted.getId());
        assertEquals(OBJECT_DESC, objectConverted.getDescription());
    }
}