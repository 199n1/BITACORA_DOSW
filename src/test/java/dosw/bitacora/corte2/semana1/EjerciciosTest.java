package dosw.bitacora.corte2.semana1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class EjerciciosTest {

    private List<Estudiante> estudiantes;

    private Ejercicio1 ej1;
    private Ejercicio2 ej2;
    private Ejercicio3 ej3;
    private Ejercicio4 ej4;
    private Ejercicio5 ej5;
    private Ejercicio6 ej6;
    private Ejercicio7 ej7;
    private Ejercicio8 ej8;
    private Ejercicio9 ej9;
    private Ejercicio10 ej10;

    @BeforeEach
    void setUp() {
        ej1  = new Ejercicio1();
        ej2  = new Ejercicio2();
        ej3  = new Ejercicio3();
        ej4  = new Ejercicio4();
        ej5  = new Ejercicio5();
        ej6  = new Ejercicio6();
        ej7  = new Ejercicio7();
        ej8  = new Ejercicio8();
        ej9  = new Ejercicio9();
        ej10 = new Ejercicio10();
        estudiantes = buildEstudiantes();
    }

    @Test
    @DisplayName("Ej1 - Solo retorna estudiantes NARANJA")
    void ej1_filtroNaranja() {
        List<Estudiante> r = ej1.obtenerEstudiantesNaranja(estudiantes);
        assertEquals(2, r.size());
        assertTrue(r.stream().allMatch(e -> "NARANJA".equals(e.getEquipo())));
    }

    @Test
    @DisplayName("Ej1 - Lista vacía retorna vacío")
    void ej1_listaVacia() {
        assertTrue(ej1.obtenerEstudiantesNaranja(Collections.emptyList()).isEmpty());
    }

    @Test
    @DisplayName("Ej2 - Nombres en orden alfabético")
    void ej2_nombresOrdenados() {
        List<String> r = ej2.obtenerNombresOrdenados(estudiantes);
        assertEquals(estudiantes.size(), r.size());
        assertEquals("Ana", r.get(0));
        assertEquals("Pedro", r.get(r.size() - 1));
    }

    @Test
    @DisplayName("Ej3 - Promedio general en rango válido")
    void ej3_promedioGeneral() {
        double p = ej3.calcularPromedioGeneral(estudiantes);
        assertTrue(p > 0 && p <= 5.0);
    }

    @Test
    @DisplayName("Ej3 - Lista vacía retorna 0.0")
    void ej3_listaVacia() {
        assertEquals(0.0, ej3.calcularPromedioGeneral(Collections.emptyList()));
    }

    @Test
    @DisplayName("Ej4 - Mapa contiene las materias del estudiante")
    void ej4_promedioPorMateria() {
        Estudiante ana = estudiantes.get(0);
        Map<String, Double> r = ej4.calcularPromedioPorMateria(ana);
        assertFalse(r.isEmpty());
        assertTrue(r.containsKey("DOSW"));
        r.values().forEach(v -> assertTrue(v >= 0 && v <= 5));
    }

    @Test
    @DisplayName("Ej5 - Retorna el estudiante con mayor promedio")
    void ej5_mejorEstudiante() {
        List<Nota> perfectas = List.of(
                new Nota("DOSW", 5.0, LocalDate.now(), true),
                new Nota("BD",   5.0, LocalDate.now(), true)
        );
        List<Estudiante> con = new ArrayList<>(estudiantes);
        con.add(new Estudiante("99", "Crack", "VERDE", perfectas));
        assertEquals("Crack", ej5.obtenerMejorEstudiante(con).getNombre());
    }

    @Test
    @DisplayName("Ej5 - Lista vacía lanza excepción")
    void ej5_listaVacia() {
        assertThrows(NoSuchElementException.class,
                () -> ej5.obtenerMejorEstudiante(Collections.emptyList()));
    }

    @Test
    @DisplayName("Ej6 - Reprobadas por equipo no negativas")
    void ej6_reprobadasPorEquipo() {
        Map<String, Long> r = ej6.contarReprobadasPorEquipo(estudiantes);
        assertFalse(r.isEmpty());
        r.values().forEach(v -> assertTrue(v >= 0));
    }

    @Test
    @DisplayName("Ej7 - Retorna máximo 3 y en orden descendente")
    void ej7_top3() {
        List<Estudiante> r = ej7.obtenerTop3Aprobados(estudiantes);
        assertTrue(r.size() <= 3);
        if (r.size() >= 2) {
            long a1 = r.get(0).getNotas().stream().filter(Nota::isAprobada).count();
            long a2 = r.get(1).getNotas().stream().filter(Nota::isAprobada).count();
            assertTrue(a1 >= a2);
        }
    }

    @Test
    @DisplayName("Ej8 - Categorías válidas y total igual al original")
    void ej8_clasificacion() {
        Map<String, List<Estudiante>> r = ej8.clasificarPorEstadoAcademico(estudiantes);
        Set<String> validas = Set.of("ALTO RENDIMIENTO", "REGULAR", "RIESGO");
        assertTrue(validas.containsAll(r.keySet()));
        long total = r.values().stream().mapToLong(List::size).sum();
        assertEquals(estudiantes.size(), total);
    }

    @Test
    @DisplayName("Ej9 - Retorna nombre de materia conocida")
    void ej9_materiaConMasReprobaciones() {
        String r = ej9.obtenerMateriaConMasReprobaciones(estudiantes);
        Set<String> validas = Set.of("DOSW", "BD", "REDES", "Sin reprobaciones");
        assertTrue(validas.contains(r));
    }

    @Test
    @DisplayName("Ej9 - Lista vacía retorna mensaje")
    void ej9_listaVacia() {
        assertEquals("Sin reprobaciones",
                ej9.obtenerMateriaConMasReprobaciones(Collections.emptyList()));
    }

    @Test
    @DisplayName("Ej10 - Retorna LinkedHashMap ordenado desc")
    void ej10_pipeline() {
        LinkedHashMap<String, Double> r = ej10.promedioAprobadosNaranjaOrdenado(estudiantes);
        assertInstanceOf(LinkedHashMap.class, r);
        List<Double> vals = new ArrayList<>(r.values());
        for (int i = 0; i < vals.size() - 1; i++) {
            assertTrue(vals.get(i) >= vals.get(i + 1));
        }
    }

    @Test
    @DisplayName("Ej10 - Sin NARANJA retorna vacío")
    void ej10_sinNaranja() {
        List<Estudiante> soloAzul = List.of(
                new Estudiante("9", "X", "AZUL", List.of(
                        new Nota("BD", 4.0, LocalDate.now(), true)
                ))
        );
        assertTrue(ej10.promedioAprobadosNaranjaOrdenado(soloAzul).isEmpty());
    }

    private List<Estudiante> buildEstudiantes() {
        List<Nota> notasAna = Arrays.asList(
                new Nota("DOSW",  4.8, LocalDate.of(2024, 3, 10), true),
                new Nota("BD",    4.6, LocalDate.of(2024, 3, 15), true),
                new Nota("REDES", 4.9, LocalDate.of(2024, 3, 20), true)
        );
        List<Nota> notasCarlos = Arrays.asList(
                new Nota("DOSW",  3.8, LocalDate.of(2024, 3, 10), true),
                new Nota("BD",    2.5, LocalDate.of(2024, 3, 15), false),
                new Nota("REDES", 4.0, LocalDate.of(2024, 3, 20), true)
        );
        List<Nota> notasLuis = Arrays.asList(
                new Nota("DOSW",  3.5, LocalDate.of(2024, 3, 10), true),
                new Nota("BD",    2.0, LocalDate.of(2024, 3, 15), false),
                new Nota("REDES", 3.8, LocalDate.of(2024, 3, 20), true)
        );
        List<Nota> notasPedro = Arrays.asList(
                new Nota("DOSW",  2.0, LocalDate.of(2024, 3, 10), false),
                new Nota("BD",    2.5, LocalDate.of(2024, 3, 15), false),
                new Nota("REDES", 3.0, LocalDate.of(2024, 3, 20), false)
        );
        return Arrays.asList(
                new Estudiante("1", "Ana",    "NARANJA", notasAna),
                new Estudiante("2", "Carlos", "NARANJA", notasCarlos),
                new Estudiante("3", "Luis",   "AZUL",    notasLuis),
                new Estudiante("4", "Pedro",  "VERDE",   notasPedro)
        );
    }
}
