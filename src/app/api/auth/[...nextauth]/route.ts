import NextAuth from "next-auth";
import CredentialsProvider from "next-auth/providers/credentials";
import GoogleProvider from "next-auth/providers/google";


const handler = NextAuth({
  providers: [
    GoogleProvider({
      clientId: process.env.GOOGLE_CLIENT_ID as string,
      clientSecret: process.env.GOOGLE_CLIENT_SECRET as string
    }),
    CredentialsProvider({
      name: "Credentials",
      credentials: {
        email: { label: "email", type: "email", placeholder: "test@test.com" },
        password: { label: "Password", type: "password" },
      },
      async authorize(credentials, req) {
        const users = {
          id: "1",
          name: "usuarioPrueba",
          email: "jsmith@example.com",
          username: "UsuarioPrueba",
          password: "password123",
        };
        if(users) {
          return users
        } else {
          return null
        }
        // Aqui conectare algun endpoint para validar usuarios del backend
        // const res = await fetch(
        //   `https://linguish.up.railway.app/user/find/${id}`,
        //   {
        //     method: "GET",
        //     body: JSON.stringify({
        //       email: credentials?.email,
        //       password: credentials?.password,
        //     }),
        //     headers: { "Content-Type": "application/json" },
        //   }
        // );
        // const user = await res.json();

        // if (user.error) throw user;

        // return user;
      },
    }),
  ],

  pages: {
    signIn: "/login",
    signOut: "/signout"
  },
});

export { handler as GET, handler as POST };
