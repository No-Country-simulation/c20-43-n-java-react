import NextAuth from "next-auth";
import CredentialsProvider from "next-auth/providers/credentials";

const handler = NextAuth({
  providers: [
    CredentialsProvider({
      name: "Credentials",
      credentials: {
        email: { label: "email", type: "email", placeholder: "test@test.com" },
        password: { label: "Password", type: "password" },
      },
      async authorize(credentials) {
        const users = [
          {
            id: "1",
            name: "usuarioPrueba",
            email: "jsmith@example.com",
            username: "UsuarioPrueba",
            password: "password123",
          },
          {
            id: "2",
            name: "maria",
            email: "maria@example.com",
            username: "maria",
            password: "mypassword",
          },
        ];

        // const res = await fetch(
        //   `${process.env.NEXT_PUBLIC_BACKEND_URL}/auth/login`,
        //   {
        //     method: "POST",
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
        const user = users.find((u) => u.email === credentials?.email);

        if (user && user.password === credentials?.password) {
          return user;
        } else {
          return null
        }
      },
    }),
  ],

  pages: {
    signIn: "/login",
  },
});

export { handler as GET, handler as POST };
