export {default} from "next-auth/middleware"
import { NextResponse } from 'next/server'
import { NextRequest } from 'next/server'
import {getToken} from 'next-auth/jwt'

export async function middleware(request: NextRequest) {
  const token = await getToken({req: request, secret: process.env.NEXTAUTH_URL})

  if(!token) {
    return NextResponse.redirect(new URL('/', request.url))
  }

  return NextResponse.next()
}

export const config = {
    matcher: ["/dashboard"]
}