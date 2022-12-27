import jakarta.ws.rs.ApplicationPath;

//bu sınıf jakartaya özel jersey de olmaya bilir, spring rest için farklı olabilir.
@ApplicationPath("/")
public class Application extends jakarta.ws.rs.core.Application {
    // başka bir jax-rs teknolojisnde mesela resteasy mesela jersey mesela spring rest gibi
    // farklı bir konfigürasyon olur.


    //https://tomee.apache.org/comparison.html --- tomee versiyon uyumluluğunu kontrol et.
    //https://tomee.apache.org/tomee-9.0/docs/comparison.html#specifications --- jakarta uyumluluğunu servise göre kontrol et.

}
