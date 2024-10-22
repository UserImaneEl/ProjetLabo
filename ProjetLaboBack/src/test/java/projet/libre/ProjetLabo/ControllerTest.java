package projet.libre.ProjetLabo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;


public class ControllerTest {

    @InjectMocks
    private Controller controller;

    @Mock
    private LaboratoireInterface laboratoireInterface;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testAddLabo_Success() {
        // Arrange
        Laboratoire labo = new Laboratoire();

        // Act
        ResponseEntity<String> response = controller.addLabo(labo);

        // Assert
        verify(laboratoireInterface).save(labo);
        assertEquals(ResponseEntity.ok("Laboratoire ajouté avec succès"), response);
    }

    @Test
    public void testAddLabo_NullLaboratoire() {
        // Act
        ResponseEntity<String> response = controller.addLabo(null);

        // Assert
        assertEquals(BAD_REQUEST, response.getStatusCode());
        assertEquals("Laboratoire ne peut pas être null", response.getBody());
    }

    @Test
    public void testAddLabo_Exception() {
        // Arrange
        Laboratoire labo = new Laboratoire();
        doThrow(new RuntimeException("Erreur de sauvegarde")).when(laboratoireInterface).save(labo);

        // Act
        ResponseEntity<String> response = controller.addLabo(labo);

        // Assert
        assertEquals(INTERNAL_SERVER_ERROR, response.getStatusCode());
        assertEquals("Erreur lors de l'ajout du laboratoire", response.getBody());
    }
}
