export { default } from "next-auth/middleware";

import { NextResponse } from 'next/server'
import type { NextRequest } from 'next/server'
 
// This function can be marked `async` if using `await` inside
export function middleware(request: NextRequest) {
}
 

export const config = {
  matcher: ["/dashboard", "/lecture", "/rutas", "/settings", "/sobreNosotros"],
};