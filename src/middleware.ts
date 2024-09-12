export { default } from "next-auth/middleware";
import { NextResponse } from "next/server";
import { NextRequest } from "next/server";
import { getToken } from "next-auth/jwt"; // Importa getToken

export async function middleware(request: NextRequest) {
    // return NextResponse.redirect(new URL("/dashboard", request.url));
}

// Define las rutas protegidas
export const config = {
  matcher: ["/dashboard", "/lecture", "/rutas", "/settings", "/sobreNosotros"],
};