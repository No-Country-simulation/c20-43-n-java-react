import { withAuth } from "next-auth/middleware";

export default withAuth({
  pages: {
    signIn: '/login',  // Página de redirección si no están autenticados
  },
});

// Opcional: Establece rutas que requieren autenticación
export const config = {
  matcher: [
    "/dashboard",   // Ejemplo para proteger el dashboard
    "/lecture",       // Proteger rutas de administrador
  ],
};