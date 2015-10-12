/*
 * Copyright 2015 EMBL - European Bioinformatics Institute
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package embl.ebi.variation.commons.models.metadata;

import java.util.Date;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Cristina Yenyxe Gonzalez Garcia <cyenyxe@ebi.ac.uk>
 */
public class AnalysisTest {
    
    @Test
    public void testConstructorSuccessful() {
        Study study = new Study("PRJEA12345", null, null, null, null);
        Analysis analysis1 = new Analysis(study, "Analysis1", "Analysis1", "Description");
        assertEquals(analysis1.getAlias(), "Analysis1");
        assertEquals(analysis1.getTitle(), "Analysis1");
        assertEquals(analysis1.getDescription(), "Description");
        assertNull(analysis1.getCentre());
        assertNull(analysis1.getPlatform());
        assertNull(analysis1.getSoftware());
        assertFalse(analysis1.isImputation());
        assertNull(analysis1.getDate());
        
        Analysis analysis2 = new Analysis(study, "Analysis2", "Analysis2", "Description", null, null, null, true, null);
        assertEquals(analysis2.getAlias(), "Analysis2");
        assertEquals(analysis2.getTitle(), "Analysis2");
        assertEquals(analysis2.getDescription(), "Description");
        assertNull(analysis2.getCentre());
        assertNull(analysis2.getPlatform());
        assertNull(analysis2.getSoftware());
        assertTrue(analysis2.isImputation());
        assertNull(analysis2.getDate());
        
        Analysis analysis3 = new Analysis(study, "Analysis3", "Analysis3", "Description", "Centre", "Platform", "Software", false, new Date());
        assertEquals(analysis3.getAlias(), "Analysis3");
        assertEquals(analysis3.getTitle(), "Analysis3");
        assertEquals(analysis3.getDescription(), "Description");
        assertEquals(analysis3.getCentre(), "Centre");
        assertEquals(analysis3.getPlatform(), "Platform");
        assertEquals(analysis3.getSoftware(), "Software");
        assertFalse(analysis3.isImputation());
        assertNotNull(analysis3.getDate());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorNoAlias() {
        Study study = new Study("PRJEA12345", null, null, null, null);
        Analysis analysis = new Analysis(study, null, "Title", "Description", null, null, null, true, null);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testConstructorNoTitle() {
        Study study = new Study("PRJEA12345", null, null, null, null);
        Analysis analysis = new Analysis(study, "Analysis1", null, "Description", null, null, null, true, null);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testConstructorNoDescription() {
        Study study = new Study("PRJEA12345", null, null, null, null);
        Analysis analysis = new Analysis(study, "Analysis1", "Title", null, null, null, null, true, null);
    }
    
}
